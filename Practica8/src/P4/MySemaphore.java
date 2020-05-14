package P4;

/**
 *
 * @author david
 */
public class MySemaphore {
    private int value;
    
    public MySemaphore(int initialValue) {
        value = initialValue;
    }
        
    // initialize a sempahore with value zero
    public MySemaphore() {
        this(0);
    }
    
    public void up() {
        synchronized(this)
            {
                while(this.value==0){
                   try{
                        this.wait(); 
                   }
                   catch(InterruptedException e) {}
                }
                this.notify();
            }
    }

    public void down() throws InterruptedException{
        synchronized(this)
            {
                while(this.value==1){
                   try{
                        this.wait(); 
                   }
                   catch(InterruptedException e) {}
                }
                this.notify();
            }
    }

}


