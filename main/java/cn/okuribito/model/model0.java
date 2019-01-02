package cn.okuribito.model;

public class model0 {

    protected void getModelCode(){
        System.out.println("ModelCode:model0");
    }

    private String a;
    private String b;


    public model0(String a,String b){
        this.a = a;
        this.b = b;
    }



    public model0(String a){
        System.out.println(a);
    }

    public model0(){}

    public model0 returnNew(){
        System.out.println("在堆上new一个model0的对象");
        long a = 1000l;
        long b = 1000;
        long c = 1000_1000;
        short d = 100_00;
        byte e = 1_00;
        int f = 1000_0000;
        System.out.println(a+b+c+d+e+f);
        return new model0();

//        model0 model0 = new model0("1","c");
//        System.out.println(model0.a);
    }
}
