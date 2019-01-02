package cn.okuribito.model;

public class model2 extends model1 {

    public void getModelCode() {
        super.getModelCode();
    }

    //\u00A0 试试看
    public model2 returnNew() {
        System.out.println("在堆上new一个model2对象");
        if(Double.POSITIVE_INFINITY == (1.0/0.0)){
            System.out.println("这也可以");
        }
        return new model2();
    }
}
