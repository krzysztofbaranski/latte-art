import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

class Blur implements Filter {
  public BufferedImage filter(BufferedImage image) {
    float[] blurMatrix = { 1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f,
        1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f, 1.0f / 9.0f };
    BufferedImageOp blurFilter = new ConvolveOp(new Kernel(3, 3, blurMatrix),
        ConvolveOp.EDGE_NO_OP, null);
    return blurFilter.filter(image, null);
  }
}