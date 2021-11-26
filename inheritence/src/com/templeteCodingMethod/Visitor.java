package com.templeteCodingMethod;

public class Visitor {
    public void visit(Prisoners prisoners){
        System.out.println("--------start visit---------");
        prisoners.life();
        System.out.println("--------end visit----------");
    }

    public static void main(String[] args) {
        Visitor visitor = new Visitor();
        Prisoners wyf = new StarPrisoner("Yifan Wu");
        Prisoners xjp = new PoliticalPrisoner("JinPin Xi");
        visitor.visit(wyf);
        visitor.visit(xjp);
    }
}
