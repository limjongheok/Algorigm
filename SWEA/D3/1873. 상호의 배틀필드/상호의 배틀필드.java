/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        InputClassification inputClassification = InputClassification.getInstance;
        InputOrderClassification inputOrderClassification = InputOrderClassification.getInstance;

        int t = Integer.parseInt(br.readLine());


        // 초기 탱크
        for(int tc = 1; tc<=t; tc++){

            Tank tank = null;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Map map = new Map(n,m);
            // map 구현
            for(int i=0; i<n; i++){
                String inputAll = br.readLine();
                for(int j=0; j<m; j++){
                    char input = inputAll.charAt(j);

                    Object o  =inputClassification.createObject(input,i,j);


                    if(o instanceof Tank){
                        tank = (Tank) o;
                    }
                    map.setMap(i,j,o);
                }
            }


            int orderNum = Integer.parseInt(br.readLine());
            String orderAll = br.readLine();
            for(int i=0; i<orderNum; i++){
                char order = orderAll.charAt(i);
                inputOrderClassification.command(order,tank,map);

            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
            for(int z=0; z< map.getMaxX(); z++){
                for(int j=0; j<map.getMaxY(); j++){
                    sb.append(map.getMapObject(z,j));
                }
                sb.append("\n");
            }
            System.out.print(sb);





        }
    }
}
class InputClassification{

    private InputClassification(){

    }

    private static InputClassification instance(){
        return new InputClassification();
    }
    public static InputClassification getInstance = instance();

    public Object createObject(char input, int x, int y){
        switch (input){
            case '.':
                return   new Flat(x,y,Shape.flat);
            case '*':
                return new BrickWall(x,y,Shape.brickWall);
            case '#':
                return new SteelWall(x,y,Shape.steelWall);
            case '-':
                return new Water(x,y,Shape.water);
            case'^':
                return  new Tank(x,y,Direction.up,Direction.up);
            case 'v':
                return new Tank(x,y,Direction.down,Direction.down);
            case '>':
                return new Tank(x,y,Direction.right,Direction.right);
            case '<':
                return new Tank(x,y,Direction.left,Direction.left);
            default:
                return null;
        }
    }
}

class InputOrderClassification{

    private InputOrderClassification(){

    }

    private static InputOrderClassification instance(){
        return  new InputOrderClassification();
    }
    public static InputOrderClassification getInstance = instance();
    public void command (char order, Tank tank , Map map){
        switch (order){
            case 'U':
                commandUp(tank,map);
                break;

            case 'D':
                commandDown(tank,map);
                break;
            case 'L':
                commandLeft(tank,map);
                break;
            case 'R':
                commandRight(tank,map);
                break;
            case'S':
                commandShoot(tank,map);
                break;
        }
    }

    private void commandUp(Tank tank,Map map){
        int nextX = tank.getX()-1;
        tank.setShape('^');
        tank.setDirection(Direction.up);
        if(nextX >=0){
            if(map.getMapObject(nextX,tank.getY()) instanceof Flat){
                map.setMap(tank.getX(),tank.getY(),new Flat(tank.getX(),tank.getY(),Shape.flat)); // 현재 좌표 Flat로
                tank.setX(nextX);
                map.setMap(nextX,tank.getY(),tank); // 다음좌표 탱크로

            }
        }

    }
    private void commandDown(Tank tank, Map map){
        int nextX = tank.getX()+1;
        tank.setShape('v');
        tank.setDirection(Direction.down);
        if(nextX <map.getMaxX()){
            if(map.getMapObject(nextX,tank.getY()) instanceof Flat){
                map.setMap(tank.getX(),tank.getY(),new Flat(tank.getX(),tank.getY(),Shape.flat));
                tank.setX(nextX);
                map.setMap(nextX,tank.getY(),tank);

            }
        }





    }
    private void commandLeft(Tank tank, Map map){
        int nextY = tank.getY()-1;
        tank.setShape('<');
        tank.setDirection(Direction.left);
        if(nextY >=0){
            if(map.getMapObject(tank.getX(),nextY) instanceof Flat){
                map.setMap(tank.getX(),tank.getY(),new Flat(tank.getX(),tank.getY(),Shape.flat));
                tank.setY(nextY);
                map.setMap(tank.getX(),nextY,tank);

            }
        }
    }
    private void commandRight(Tank tank, Map map){
        int nextY = tank.getY()+1;
        tank.setShape('>');
        tank.setDirection(Direction.right);
        if(nextY <map.getMaxY()){
            if(map.getMapObject(tank.getX(),nextY) instanceof Flat){
                map.setMap(tank.getX(),tank.getY(),new Flat(tank.getX(),tank.getY(),Shape.flat));
                tank.setY(nextY);
                map.setMap(tank.getX(),nextY,tank);
            }
        }
    }

    private void commandShoot(Tank tank, Map map){

        Direction direction = tank.getDirection();


        if (direction.equals(Direction.up)){
            upShoot(tank,map);
        } else if (direction.equals(Direction.down)) {
            downShoot(tank,map);
        } else if (direction.equals(Direction.left)) {
            leftShoot(tank,map);
        } else if (direction.equals(Direction.right)) {
            rightShoot(tank,map);
        }

    }

    private void upShoot(Tank tank, Map map){
        int x = getTankX(tank) -1;
        int y = getTankY(tank);

        while(x >=0){

            Object object = map.getObject(x,y);
            if(object instanceof BrickWall){
                map.setMap(x,y,new Flat(x,y,Shape.flat));
                break;
            }
            if(object instanceof SteelWall){
                break;
            }
            x -=1;
        }

    }

    private void downShoot(Tank tank, Map map){

        int x = getTankX(tank) +1;
        int y = getTankY(tank);

        while(x < map.getMaxX()){

            Object object = map.getObject(x,y);
            if(object instanceof BrickWall){
                map.setMap(x,y,new Flat(x,y,Shape.flat));
                break;
            }
            if(object instanceof SteelWall){
                break;
            }
            x +=1;
        }

    }

    private void leftShoot(Tank tank, Map map){

        int x = getTankX(tank);
        int y = getTankY(tank)-1;

        while(y >= 0){

            Object object = map.getObject(x,y);
            if(object instanceof BrickWall){
                map.setMap(x,y,new Flat(x,y,Shape.flat));
                break;
            }
            if(object instanceof SteelWall){
                break;
            }
            y -=1;
        }
    }

    private void rightShoot(Tank tank, Map map){
        int x = getTankX(tank);
        int y = getTankY(tank)+1;
        while(y < map.getMaxY()){


            Object object = map.getObject(x,y);

            if(object instanceof BrickWall){
                map.setMap(x,y,new Flat(x,y,Shape.flat));
                break;
            }
            if(object instanceof SteelWall){
                break;
            }
            y +=1;
        }

    }

    private int getTankX(Tank tank){
        return tank.getX();
    }
    private int getTankY(Tank tank){
        return tank.getY();
    }
}

enum Direction{
    up('^'),
    down('v'),
    left('<'),
    right('>');

    private final char shape;
    Direction(char shape) {
        this.shape = shape;
    }
    public char getShape() {
        return shape;
    }


}

enum Shape{
    flat('.'),
    brickWall('*'),
    steelWall('#'),
    water('-');

    private final char shape;

    Shape(char shape) {
        this.shape = shape;
    }

    public char getShape() {
        return shape;
    }
}

class Map{
    private final int maxX;
    private final int maxY;
    Object map[][];
    public  Map(int x, int y){
        this.map = new Object[x][y];
        maxX = x;
        maxY = y;
    }

    public void setMap(int x, int y, Object o){
        this.map[x][y] = o;
    }

    public  Object getObject(int x, int y){
        return map[x][y];
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public Object getMapObject(int x, int y) {
        return map[x][y];
    }
}
class  Object{
    int x;
    int y;

    char shape;

    @Override
    public String toString() {
        return String.valueOf(this.shape);
    }
}
class  Flat extends Object{ // 풀

    public Flat(int x, int y, Shape shape) {

        this.x = x;
        this.y = y;
        this.shape = shape.getShape();
    }

}
class Tank extends Object{
    Direction direction;

    public Tank(int x, int y ,Direction direction, Direction shape) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.shape = shape.getShape();
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    public void setShape(char shpae){
        this.shape = shpae;
    }


    public void setDirection(Direction direction) {
        this.direction = direction;
    }



}

class BrickWall extends Object{ //돌벽

    public BrickWall(int x, int y, Shape shape) {
        this.x = x;
        this.y = y;
        this.shape = shape.getShape();
    }

}

class SteelWall extends Object{
    public SteelWall(int x, int y, Shape shape) {
        this.x = x;
        this.y = y;
        this.shape = shape.getShape();
    }

}
class Water extends Object{

    public Water(int x, int y, Shape shape) {
        this.x = x;
        this.y = y;
        this.shape = shape.getShape();
    }

}