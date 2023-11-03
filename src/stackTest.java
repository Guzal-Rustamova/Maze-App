public class stackTest {
    public static void main(String[] args) {
        MyStack<Square> squares = new MyStack<>();

        squares.push(new Square(1, 1, 1));
        squares.push(new Square(1, 1, 1));
        squares.push(new Square(1, 1, 1));
        System.out.println(squares.size());

        squares.pop();
        squares.pop();

        System.out.println(squares.isEmpty());
        System.out.println(squares.size());
        squares.pop();

        System.out.println(squares.isEmpty());
        System.out.println(squares.size());

        squares.push(new Square(1, 1, 1));
        squares.push(new Square(1, 1, 1));
        squares.push(new Square(1, 1, 1));

        System.out.println(squares.isEmpty());

        squares.clear();

        System.out.println(squares.isEmpty());
    }
}