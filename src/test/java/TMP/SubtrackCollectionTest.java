package TMP;

import org.junit.Test;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static junit.framework.TestCase.assertEquals;

public class SubtrackCollectionTest {

    @Test
    public void test1() {
        List<Dto> dtoList = LongStream.rangeClosed(1, 10).mapToObj(i -> new Dto(i, java.util.UUID.randomUUID().toString())).collect(Collectors.toList());
        List<Long> ids = LongStream.rangeClosed(0, 0).boxed().collect(Collectors.toList());
        dtoList.add(new Dto(null, "null"));

        List<Dto> retainDtoList = dtoList.stream()
                .filter(dto -> ids.stream()
                        .filter(Objects::nonNull)
                        .noneMatch(id -> Objects.equals(id, dto.id)))
                .collect(Collectors.toList());

        assertEquals(11, dtoList.size());
        assertEquals(11, retainDtoList.size());
    }

    private static class Dto {
        public Long id;
        public String msg;

        Dto(Long id, String msg) {
            this.id = id;
            this.msg = msg;
        }
    }
}
