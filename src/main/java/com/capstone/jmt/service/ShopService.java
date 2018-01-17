package com.capstone.jmt.service;

import com.capstone.jmt.data.*;
import com.capstone.jmt.mapper.OrderMapper;
import com.capstone.jmt.mapper.ShopMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Jabito on 15/02/2017.
 */
@Service("shopService")
public class ShopService {


    private static final Logger logger = LoggerFactory.getLogger(ShopService.class);



    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public LoginUser validateUser(LoginUser user) {
        logger.info("loadUserByUsername");
        System.out.println("SA SERVICE NA TO" + user.getEmail());
        LoginUser account = shopMapper.loadUserByEmail(user.getEmail());
        if (null != account){
            return account;
        }else
        return null;
    }

    public List<LoginUser> getAllUsers(){
        logger.info("getAllUsers");
        return shopMapper.getAllUsers();
    }

    public List<Material> getAllMaterials(){
        logger.info("getAllMaterials");
        return shopMapper.getAllMaterials();
    }

    public boolean addUser(LoginUser loginUser){
        logger.info("adding New User");
        LoginUser loginUser1 = shopMapper.loadUserByEmpId(loginUser.getEmpId());
        if(null == loginUser1){
            switch (loginUser.getRefRoleUserId()){

                case 0:
                    loginUser.setEmpId("PRM" + String.valueOf(shopMapper.getLastId(loginUser.getRefRoleUserId())));
                    shopMapper.incrementId(loginUser.getRefRoleUserId());
                    break;
                case 1:
                    loginUser.setEmpId("CE" + String.valueOf(shopMapper.getLastId(loginUser.getRefRoleUserId())));
                    shopMapper.incrementId(loginUser.getRefRoleUserId());
                    break;
                case 2:
                    loginUser.setEmpId("AM" + String.valueOf(shopMapper.getLastId(loginUser.getRefRoleUserId())));
                    shopMapper.incrementId(loginUser.getRefRoleUserId());
                    break;
                case 3:
                    loginUser.setEmpId("PUM" + String.valueOf(shopMapper.getLastId(loginUser.getRefRoleUserId())));
                    shopMapper.incrementId(loginUser.getRefRoleUserId());
                    break;
                case 4:
                    loginUser.setEmpId("SCM" + String.valueOf(shopMapper.getLastId(loginUser.getRefRoleUserId())));
                    shopMapper.incrementId(loginUser.getRefRoleUserId());
                    break;
                case 5:
                    loginUser.setEmpId("EP" + String.valueOf(shopMapper.getLastId(loginUser.getRefRoleUserId())));
                    shopMapper.incrementId(loginUser.getRefRoleUserId());
                    break;
                case 6:
                    loginUser.setEmpId("PP" + String.valueOf(shopMapper.getLastId(loginUser.getRefRoleUserId())));
                    shopMapper.incrementId(loginUser.getRefRoleUserId());
                    break;
                case 7:
                    loginUser.setEmpId("AA" + String.valueOf(shopMapper.getLastId(loginUser.getRefRoleUserId())));
                    shopMapper.incrementId(loginUser.getRefRoleUserId());
                    break;
                case 8:
                    loginUser.setEmpId("ADMIN" + String.valueOf(shopMapper.getLastId(loginUser.getRefRoleUserId())));
                    shopMapper.incrementId(loginUser.getRefRoleUserId());
                    break;

            }
            shopMapper.addUser(loginUser);
            return true;

        }else
        return false;
    }

    public List<RefUser> getRefUsers(){
        return shopMapper.getRefUsers();
    }

//    public ShopLogin getShopLoginById(String id) {
//        logger.info("getShopLoginById");
//        ShopLogin shopUser = shopMapper.getShopLoginById(id);
//        logger.info("getShopLoginById", shopUser);
//        return shopUser;
//    }
//
//    public ShopInfo getShopInfoById(String id) {
//        logger.info("getShopInfoById");
//        ShopInfo shopUser = shopMapper.getShopInfoById(id);
//        logger.info("getShopInfoById", shopUser);
//        return shopUser;
//    }
//
//    public ShopLocation getShopLocationById(String id) {
//        logger.info("getShopLocationById");
//        ShopLocation customer = shopMapper.getShopLocationById(id);
//        logger.info("getShopLocationById", customer);
//        return customer;
//    }
//
//    public ShopSalesInformation getShopSalesInformationById(String id) {
//        logger.info("getShopSalesInformation");
//        ShopSalesInformation order = shopMapper.getShopSalesInformationById(id);
//        logger.info("getShopSalesInformation", order);
//        return order;
//    }
//
//    public void updateShopInfo(ShopInfo shop) {
//        logger.info("updateShopInfo");
//        Integer ret = shopMapper.updateShopInfo(shop);
//    }
//
//    public void updateShopLogin(ShopLogin shop) {
//        logger.info("updateShopLogin");
//        Integer ret = shopMapper.updateShopLogin(shop);
//    }
//
//    public void addShopLocation(ShopLocation shop) {
//        logger.info("addShopLocation");
//        Integer ret = shopMapper.addShopLocation(shop);
//    }
//
//    public void updateShopLocation(ShopLocation shop) {
//        logger.info("updateShopLocation");
//        Integer ret = shopMapper.updateShopLocation(shop);
//    }
//
//    public void addShopSalesInformation(ShopSalesInformation shop) {
//        logger.info("addContainersOffered");
//        Integer ret = shopMapper.addShopSalesInformation(shop);
//    }
//
//    public void updateShopSalesInformation(ShopSalesInformation shop) {
//        logger.info("updateContainersOffered");
//        Integer ret = shopMapper.updateShopSalesInformation(shop);
//    }
//
//    public Double getTotalSales(String shopId) {
//        logger.info("getTotalSales");
//        Double sales = shopMapper.getTotalSalesById(shopId);
//
//        return sales;
//    }
//
//    public Integer getSalesCount(String shopId) {
//        logger.info("getSalesCount");
//        Integer count = shopMapper.getSalesCount(shopId);
//
//        return count;
//    }
//
//    public String getShopRating(String shopId) {
//        logger.info("getShopRating");
//        return shopMapper.getShopRating(shopId);
//    }
//
//    public List getOrdersForToday(String shopId) {
//        logger.info("getOrdersForToday");
//        return orderMapper.getOrdersForToday(shopId);
//    }
//
//    public List getLastSevenDays(String shopId) {
//        logger.info("getLastSevenDays");
//        List<OrderInfo> orders = orderMapper.getLastSevenDays(shopId);
//        String startDate;
//        Integer sold=0;
//        Double sales=0.0;
//        List<LastSevenDays> lastSeven = new ArrayList<>();
//        if(null != orders && orders.size() >0) {
//            startDate = orders.get(0).getCreatedOn();
//            for (OrderInfo order : orders) {
//                if (!order.getCreatedOn().equals(startDate)) {
//                    LastSevenDays lsd = new LastSevenDays();
//                    lsd.setDate(startDate);
//                    lsd.setSold(sold);
//                    lsd.setSales(sales);
//                    lastSeven.add(lsd);
//                    sold = 0;
//                    sales = 0.0;
//                    startDate = order.getCreatedOn();
//                    if(null != order.getRoundOrdered())
//                        sold += order.getRoundOrdered();
//                    if(null != order.getTotalCost())
//                        sales += order.getTotalCost();
//                } else {
//                    if(null != order.getRoundOrdered())
//                        sold += order.getRoundOrdered();
//                    if(null != order.getTotalCost())
//                        sales += order.getTotalCost();
//                }
//            }
//            LastSevenDays lsd = new LastSevenDays();
//            lsd.setDate(startDate);
//            lsd.setSold(sold);
//            lsd.setSales(sales);
//            lastSeven.add(lsd);
//        }
//
//        return lastSeven;
//    }
//
//    public Double getTotalSalesToday(String staffOf) {
//        return shopMapper.getTotalSalesToday(staffOf);
//    }
//
//    public String getInventoryCount(String shopId) {
//        return String.valueOf(shopMapper.getInventoryCount(shopId));
//    }
//
//    public void updateRoundStock(String username, String staffOf, Integer roundStock) {
//        shopMapper.updateRoundStock(username, staffOf, roundStock);
//    }
//
//    public void updateSlimStock(String username, String staffOf, Integer slimStock) {
//        shopMapper.updateSlimStock(username, staffOf, slimStock);
//    }
//
//    public void updatePrices(String username, String staffOf, ShopSalesInformation shop) {
//        shop.setUpdatedBy(username);
//        shop.setId(staffOf);
//        shopMapper.updatePrices(shop);
//    }
//
//
//    public void updateProfile(ShopInfo shop, String username) {
//        shop.setUpdatedBy(username);
//        shopMapper.updateShopInfo(shop);
//    }
}
