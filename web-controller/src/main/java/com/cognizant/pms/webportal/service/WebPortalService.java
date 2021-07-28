package com.cognizant.pms.webportal.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.cognizant.pms.webportal.feignclient.AuthClient;
import com.cognizant.pms.webportal.model.AssetDetails;
import com.cognizant.pms.webportal.model.AuthResponse;
import com.cognizant.pms.webportal.model.SellObjectMap;
import com.cognizant.pms.webportal.model.UserData;

@Service
public class WebPortalService {
	@Autowired
	private AuthClient authClient;

	public String postLogin(UserData user, HttpSession session, ModelMap warning) {

		UserData res = null;
		try {
			System.out.println("Under try block of postlogin service");
			res = authClient.login(user);
		} catch (Exception e) {
			String errmsg = "";
			if (e.getClass().toString().contains("feign.RetryableException"))
				errmsg = "Site is Temporarily down. Try again later.";
			else
				errmsg = "Unable to login. please check your credentials.";
			warning.addAttribute("errormsg", errmsg);
			return "login";
		}
		System.out.println("After try block of postlogin service");
		session.setAttribute("token", "Bearer " + res.getAuthToken());
		session.setAttribute("memberId", res.getUserid());
		return getHomePage((String) session.getAttribute("token"));
	}

	public String getHomePage(String token) {

		try {
			System.out.println("Under try block of getHomepage service");
			AuthResponse authResponse = authClient.getValidity(token);
		} catch (Exception e) {
			System.out.println("Error is :"+e);
			return "redirect:/";
		}
		System.out.println("After try block of getHomePage service");
		return "Home";

	}

	public Map<String, String> convertToMap(String[] name, String[] counts) {
		Map<String, String> map = new HashMap<String, String>();
		int v = 0;
		String count[] = new String[name.length];
		for (int j = 0; j < counts.length; j++) {
			if (!counts[j].equals("0")) {
				count[v++] = counts[j];
			}

		}
		for (int i = 0; i < count.length; i++) {
			map.put(name[i], count[i]);
		}
		return map;

	}

	public SellObjectMap sellShares(List<AssetDetails> list, int i, String[] name, String[] counts) {

		Map<String, Integer> stockIdList = new HashMap<String, Integer>();
		Map<String, Integer> mfIdList = new HashMap<String, Integer>();
		/*
		 * for(int j=0;j<list.size();j++) { if(list.get(j).getAssetid()) }
		 */
		int v = 0;
		String count[] = new String[name.length];
		for (int j = 0; j < counts.length; j++) {
			if (!counts[j].equals("0")) {
				count[v++] = counts[j];
			}

		}

		String type = "";
		for (int j = 0; j < name.length; j++) {
			System.out.println(name[j]);
			System.out.println(count[j]);
			for (int k = 0; k < list.size(); k++) {
				if (list.get(k).getAssetid().equals(name[j])) {
					type = list.get(k).getType();
				}
			}
			if (type.equals("Share")) {
				stockIdList.put(name[j], Integer.parseInt(count[j]));
			} else if (type.equals("MF")) {
				mfIdList.put(name[j], Integer.parseInt(count[j]));
			}
		}
		System.out.println("stock" + stockIdList.toString());
		System.out.println("mf" + mfIdList.toString());
		SellObjectMap sell = new SellObjectMap(i, stockIdList, mfIdList);
		return sell;
	}

	public Boolean isSessionValid(String token) {
		try {
			AuthResponse authResponse = authClient.getValidity(token);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
