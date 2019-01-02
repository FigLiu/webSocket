package cn.okuribito.model;

public class model1 extends model0 {

    public void getModelCode(){
        System.out.println("ModelCode:model1");
    }


    public model1 returnNew(){
        System.out.println("文件来了");
        return new model1();
    }

}
