package exception;

public class TabletteNotFoundException extends RuntimeException{
        public TabletteNotFoundException(Integer id) {
        super("Could not find employee " + id);
        }
}
