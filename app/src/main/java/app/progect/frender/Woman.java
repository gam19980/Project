package app.progect.frender;

public class Woman
{

    public void main(String[] args) {

    }
    static class MyWoman {
        String name;
        int id;
        int age;
        int img;
        int norm;

        public int getImg() {
            return img;
        }

        public MyWoman(String name, int id, int age, int img, int norm) {
            this.name=name;
            this.age=age;
            this.id=id;
            this.img=img;
            this.norm=norm;
        }
    }
}