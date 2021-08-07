package com.allen.design.patterns.creation.simple.factory;

/**
 * @author ligenfeng
 * @date 2021/4/25 10:34 下午
 */
public class Factory {

    public static Product createProduct(String productName) {
        if (productName.equals("ProductA")) {
            return new ProductA();
        } else {
            return new ProductB();
        }
    }
}
