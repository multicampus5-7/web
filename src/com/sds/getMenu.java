package com.sds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class getMapData
 */
@WebServlet("/getMenu")
public class getMenu extends HttpServlet {
	
	JSONArray ja = new JSONArray();
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@SuppressWarnings("unchecked")
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Menu> list = new ArrayList<>();
		
		if (ja.size() < 5) {
			list.add(new Menu("001", "Burger1", 10000, 10));
			list.add(new Menu("002", "Burger2", 10000, 10));
			list.add(new Menu("003", "Burger3", 10000, 10));
			list.add(new Menu("004", "Burger4", 10000, 10));
			list.add(new Menu("005", "Burger5", 10000, 10));
			
			for(Menu m:list) {
				JSONObject obj = new JSONObject();
				obj.put("id", m.getId());
				obj.put("name", m.getName());
				obj.put("price", m.getPrice());
				obj.put("stock", m.getStock());
				ja.add(obj);
			}
		}
		
		String data = request.getParameter("order");
		if (data != null) {
			int order_id = Integer.parseInt(data.substring(0,data.indexOf('&'))) - 1;
			int order_stock = Integer.parseInt(data.substring(data.indexOf('&') + 1));
			JSONObject obj = new JSONObject();
			obj = (JSONObject) ja.get(order_id);
			int origin_stock = (int) obj.get("stock");
			
			if (origin_stock < order_stock) {
				return;
			}
			obj.put("stock", origin_stock - order_stock);
		}
		
		String supply_data = request.getParameter("supply");
		if (supply_data != null) {
			int item_number_first_index = supply_data.indexOf('&');
			int item_number_last_index = supply_data.indexOf('&',item_number_first_index + 1);
			int item_number = Integer.parseInt(supply_data.substring(item_number_first_index + 1, item_number_last_index));
			int att_number_first_index = supply_data.indexOf('%');
			int att_number_last_index = supply_data.indexOf('%',att_number_first_index + 1);
			int att_number = Integer.parseInt(supply_data.substring(att_number_first_index + 1, att_number_last_index));
			ArrayList<Menu> list2 = new ArrayList<>();
			
			String id = "001";
			int deep_number_first_index = supply_data.indexOf('@');
			int deep_number_last_index = supply_data.indexOf('@',deep_number_first_index + 1);
			String name = supply_data.substring(deep_number_first_index + 1, deep_number_last_index);
			deep_number_first_index = supply_data.indexOf('@',deep_number_last_index + 1);
			deep_number_last_index = supply_data.indexOf('@',deep_number_first_index + 1);
			int stock = Integer.parseInt(supply_data.substring(deep_number_first_index + 1, deep_number_last_index));
			deep_number_first_index = supply_data.indexOf('@',deep_number_last_index + 1);
			deep_number_last_index = supply_data.indexOf('@',deep_number_first_index + 1);
			int price = Integer.parseInt(supply_data.substring(deep_number_first_index + 1, deep_number_last_index));
			list2.add(new Menu(id, name, price, stock));
			
			id = "002";
			deep_number_first_index = supply_data.indexOf('@',deep_number_last_index + 1);
			deep_number_last_index = supply_data.indexOf('@',deep_number_first_index + 1);
			name = supply_data.substring(deep_number_first_index + 1, deep_number_last_index);
			deep_number_first_index = supply_data.indexOf('@',deep_number_last_index + 1);
			deep_number_last_index = supply_data.indexOf('@',deep_number_first_index + 1);
			stock = Integer.parseInt(supply_data.substring(deep_number_first_index + 1, deep_number_last_index));
			deep_number_first_index = supply_data.indexOf('@',deep_number_last_index + 1);
			deep_number_last_index = supply_data.indexOf('@',deep_number_first_index + 1);
			price = Integer.parseInt(supply_data.substring(deep_number_first_index + 1, deep_number_last_index));
			list2.add(new Menu(id, name, price, stock));
			
			id = "003";
			deep_number_first_index = supply_data.indexOf('@',deep_number_last_index + 1);
			deep_number_last_index = supply_data.indexOf('@',deep_number_first_index + 1);
			name = supply_data.substring(deep_number_first_index + 1, deep_number_last_index);
			deep_number_first_index = supply_data.indexOf('@',deep_number_last_index + 1);
			deep_number_last_index = supply_data.indexOf('@',deep_number_first_index + 1);
			stock = Integer.parseInt(supply_data.substring(deep_number_first_index + 1, deep_number_last_index));
			deep_number_first_index = supply_data.indexOf('@',deep_number_last_index + 1);
			deep_number_last_index = supply_data.indexOf('@',deep_number_first_index + 1);
			price = Integer.parseInt(supply_data.substring(deep_number_first_index + 1, deep_number_last_index));
			list2.add(new Menu(id, name, price, stock));
			
			id = "004";
			deep_number_first_index = supply_data.indexOf('@',deep_number_last_index + 1);
			deep_number_last_index = supply_data.indexOf('@',deep_number_first_index + 1);
			name = supply_data.substring(deep_number_first_index + 1, deep_number_last_index);
			deep_number_first_index = supply_data.indexOf('@',deep_number_last_index + 1);
			deep_number_last_index = supply_data.indexOf('@',deep_number_first_index + 1);
			stock = Integer.parseInt(supply_data.substring(deep_number_first_index + 1, deep_number_last_index));
			deep_number_first_index = supply_data.indexOf('@',deep_number_last_index + 1);
			deep_number_last_index = supply_data.indexOf('@',deep_number_first_index + 1);
			price = Integer.parseInt(supply_data.substring(deep_number_first_index + 1, deep_number_last_index));
			list2.add(new Menu(id, name, price, stock));
			
			id = "005";
			deep_number_first_index = supply_data.indexOf('@',deep_number_last_index + 1);
			deep_number_last_index = supply_data.indexOf('@',deep_number_first_index + 1);
			name = supply_data.substring(deep_number_first_index + 1, deep_number_last_index);
			deep_number_first_index = supply_data.indexOf('@',deep_number_last_index + 1);
			deep_number_last_index = supply_data.indexOf('@',deep_number_first_index + 1);
			stock = Integer.parseInt(supply_data.substring(deep_number_first_index + 1, deep_number_last_index));
			deep_number_first_index = supply_data.indexOf('@',deep_number_last_index + 1);
			deep_number_last_index = supply_data.indexOf('@',deep_number_first_index + 1);
			price = Integer.parseInt(supply_data.substring(deep_number_first_index + 1, deep_number_last_index));
			list2.add(new Menu(id, name, price, stock));
			
			ja.clear();
			for(Menu m2:list2) {
				JSONObject obj = new JSONObject();
				obj.put("id", m2.getId());
				obj.put("name", m2.getName());
				obj.put("price", m2.getPrice());
				obj.put("stock", m2.getStock());
				ja.add(obj);
			}
		}
		

		response.setContentType("text/json;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.print(ja.toJSONString());
	}
}