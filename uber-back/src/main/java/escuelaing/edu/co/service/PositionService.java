package escuelaing.edu.co.service;

import escuelaing.edu.co.model.Position;

import java.util.Random;

public class PositionService {

    private static PositionService instance;
    private final Random random = new Random();

    private PositionService() {
    }

    public static PositionService getInstance() {
        if (instance == null) {
            synchronized (PositionService.class) {
                if (instance == null) {
                    instance = new PositionService();
                }
            }
        }
        return instance;
    }

    public Position updatePosition(Position position) {
        int newX = Integer.parseInt(position.getX()) + random.nextInt(5);
        int newY = Integer.parseInt(position.getY()) + random.nextInt(5);

        // Limitar x y y dentro del rango de 0 a 40
        newX = Math.max(0, Math.min(newX, 40));
        newY = Math.max(0, Math.min(newY, 40));

        return new Position(String.valueOf(newX), String.valueOf(newY));
    }
}
