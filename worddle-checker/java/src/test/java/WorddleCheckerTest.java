import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WorddleCheckerTest {

    @Test
    public void it_should_recognize_well_placed_letter() {
        Assertions.assertEquals(".....", new Worddle("aaaaa").guess("bbbbb"));
        Assertions.assertEquals("A....", new Worddle("aaaaa").guess("abbbb"));
        Assertions.assertEquals(".A...", new Worddle("aaaaa").guess("babbb"));
        Assertions.assertEquals("..A..", new Worddle("aaaaa").guess("bbabb"));
        Assertions.assertEquals("...A.", new Worddle("aaaaa").guess("bbbab"));
        Assertions.assertEquals("....A", new Worddle("aaaaa").guess("bbbba"));
    }

    @Test
    public void it_should_recognize_not_well_placed_letter() {
        Assertions.assertEquals(".a...", new Worddle("abbbb").guess("caccc"));
        Assertions.assertEquals("..a..", new Worddle("abbbb").guess("ccacc"));
        Assertions.assertEquals("...a.", new Worddle("abbbb").guess("cccac"));
        Assertions.assertEquals("....a", new Worddle("abbbb").guess("cccca"));
    }

    @Test
    public void it_should_favor_well_placed_letter_over_wrongly_placed_letter() {
        Assertions.assertEquals("A....", new Worddle("abbbb").guess("accca"));
        Assertions.assertEquals("A....", new Worddle("abbbb").guess("accaa"));
        Assertions.assertEquals("A..a.", new Worddle("aabbb").guess("accaa"));
        Assertions.assertEquals("AA...", new Worddle("aabbb").guess("aacaa"));
        Assertions.assertEquals("...aa", new Worddle("aabbb").guess("cccaa"));

        Assertions.assertEquals("..A..", new Worddle("bbabb").guess("aaaaa"));
    }

    @Test
    public void final_test()
    {
        Assertions.assertEquals("AAAAA", new Worddle("aaaaa").guess("aaaaa"));
        Assertions.assertEquals("BRAVO", new Worddle("bravo").guess("bravo"));
    }

}
