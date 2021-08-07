package com.allen.design.patterns.creation.simple.factory;

/**
 * @author ligenfeng
 * @date 2021/4/25 10:32 下午
 */
public class ProductA implements Product{
    @Override
    public void use() {
        System.out.println("This is ProductA.");
    }
}
