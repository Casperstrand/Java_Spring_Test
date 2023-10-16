package com.Java_Spring_Test.Java_Spring_Test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

@RestController
public class CartsController {

    private final ArrayList<Cart> CartArr;

    {
        try {
            CartArr = generateCartArr();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Cart> generateCartArr () throws IOException {
        URL url = new URL("https://dummyjson.com/carts");
        try (InputStream input = url.openStream()) {
            InputStreamReader isr = new InputStreamReader(input);
            BufferedReader reader = new BufferedReader(isr);
            StringBuilder jsonObject1 = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                jsonObject1.append((char) c);
            }
            ArrayList<Cart> arr = new ArrayList<Cart>();
            JSONObject jsonObject = new JSONObject(jsonObject1.toString());

            for (int i = 0; i < jsonObject.getJSONArray("carts").length(); i++) {
                int cartID = jsonObject.getJSONArray("carts").getJSONObject(i).getInt("id");
                int cartTotal = jsonObject.getJSONArray("carts").getJSONObject(i).getInt("total");
                int discountedTotal = jsonObject.getJSONArray("carts").getJSONObject(i).getInt("discountedTotal");
                int userId = jsonObject.getJSONArray("carts").getJSONObject(i).getInt("userId");
                int totalProducts = jsonObject.getJSONArray("carts").getJSONObject(i).getInt("totalProducts");
                int totalQuantity = jsonObject.getJSONArray("carts").getJSONObject(i).getInt("totalQuantity");
                ArrayList<Product> products = new ArrayList<Product>();
                for (int z = 0; z < jsonObject.getJSONArray("carts").getJSONObject(i).getJSONArray("products").length(); z++) {
                    int id = jsonObject.getJSONArray("carts").getJSONObject(i).getJSONArray("products").getJSONObject(z).getInt("id");
                    String title = jsonObject.getJSONArray("carts").getJSONObject(i).getJSONArray("products").getJSONObject(z).getString("title");
                    int price = jsonObject.getJSONArray("carts").getJSONObject(i).getJSONArray("products").getJSONObject(z).getInt("price");
                    int quantity = jsonObject.getJSONArray("carts").getJSONObject(i).getJSONArray("products").getJSONObject(z).getInt("quantity");
                    int total = jsonObject.getJSONArray("carts").getJSONObject(i).getJSONArray("products").getJSONObject(z).getInt("total");
                    float discountedPercentage = jsonObject.getJSONArray("carts").getJSONObject(i).getJSONArray("products").getJSONObject(z).getFloat("discountPercentage");
                    int discountedPrice = jsonObject.getJSONArray("carts").getJSONObject(i).getJSONArray("products").getJSONObject(z).getInt("discountedPrice");
                    products.add(new Product(id, title, price, quantity, total, discountedPercentage, discountedPrice));
                }
                arr.add(new Cart(cartID, products, cartTotal, discountedTotal, userId, totalProducts, totalQuantity));
            }
            return arr;
        }
    }

    @RequestMapping(value = "/getAllCarts", method = RequestMethod.GET)
    public ArrayList<Cart>  getAllCarts() throws IOException {
        return CartArr;
    }

    @RequestMapping(value = "/getCart", method = RequestMethod.GET)
    public Cart getCart(@RequestParam("id") int id) {
        Cart tempcart = null;
        for (Cart cart : CartArr) {
            if (cart.getCartID() == id) {
                tempcart = cart;
            }
        }
        return tempcart;
    }

    @RequestMapping(value = "/getCheapestCart", method = RequestMethod.GET)
    public Cart getCheapestCart () {
        Cart cheapCart = getCart(1);
        for (Cart cart : CartArr) {
            if (cart.getCartTotal() < cheapCart.getCartTotal()) {
                cheapCart = cart;
            }
        }
        return cheapCart;
    }

    @RequestMapping(value = "/getCommonShopper", method = RequestMethod.GET)
    public ArrayList<Integer> getCommonShopper(@RequestParam("item")int item) {
        ArrayList<Integer> shopperId = new ArrayList<>();
        for (Cart cart : CartArr) {
            for (Product product : cart.getProducts()) {
                if (product.getId() == item) {
                    shopperId.add(cart.getUserID());
                }
            }
        }
        return shopperId;
    }
}
