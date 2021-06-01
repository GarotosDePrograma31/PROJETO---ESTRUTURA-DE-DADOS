package grafos;

public class Aresta {
   boolean loop;
   public Aresta(){
       loop = false;
   }

   public boolean isLoop() {
       return loop;
   }

   public void setLoop(boolean loop) {
       this.loop = loop;
   }
}