package com.allen.design.patterns.creation.simple.factory;

/**
 * @author ligenfeng
 * @date 2021/4/25 10:33 下午
 */
public class ProductB implements Product{
    @Override
    public void use() {
        System.out.println("This is ProductB");
    }
}
