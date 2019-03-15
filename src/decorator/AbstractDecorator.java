package decorator;


public class AbstractDecorator extends ABattercake {

    private ABattercake aBattercake;

    public AbstractDecorator(ABattercake aBattercake) {
        this.aBattercake = aBattercake;
    }

    @Override
    protected String getDesc() {
        return aBattercake.getDesc();
    }

    @Override
    protected int cost() {
        return aBattercake.cost();
    }
}
