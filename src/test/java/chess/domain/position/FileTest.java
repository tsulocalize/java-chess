package chess.domain.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FileTest {

    @DisplayName("H와 A의 차이(gap)는 7이다.")
    @Test
    void calculateGap() {
        int actual = File.H.gap(File.A);

        assertThat(actual).isEqualTo(7);
    }

    @DisplayName("source가 target보다 작을 때 source 위치와 target 위치 사이의 File 리스트를 찾는다.")
    @Test
    void findBetweenAscTest() {
        File sourceFile = File.A;
        File targetFile = File.D;

        List<File> files = sourceFile.findBetween(targetFile);

        assertThat(files).containsExactly(File.B, File.C);
    }

    @DisplayName("source가 target보다 클 때 source 위치와 target 위치 사이의 File 리스트를 찾는다.")
    @Test
    void findBetweenDescTest() {
        File sourceFile = File.D;
        File targetFile = File.A;

        List<File> files = sourceFile.findBetween(targetFile);

        assertThat(files).containsExactly(File.C, File.B);
    }
}
