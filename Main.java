
class Main {

    public static void main(String[] args) throws Exception{
        while (true){
            Start st = new Start();
            st.printIntroduction();
    
            Game game = new Game();
            game.gameInit(st.intro());
            String res = game.gamePlay();
            if (res.equals("q")) break;
        }
    }
}
