class Complex {

    double real;
    double image;

    public void add(Complex num) {
        real = real + num.real;
        image = image + num.image;
    }

    public void subtract(Complex num) {
        real = real - num.real;
        image = image - num.image;
    }
}