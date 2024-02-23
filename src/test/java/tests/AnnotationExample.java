package tests;

class Base {

    public void display() {
        System.out.println("******************************Base display()");
    }
}

class AnnotationExample extends Base {
    @Override
    public void display()
    {
        System.out.println("****************************Derived display(int )");
    }

    public static void main(String args[])
    {
        Base obj = new Base();
        obj.display();
    }
}
