import worddle from "./worddle";

test('should recognized well placed letter', () => {
    expect(worddle('aaaaa').guess('bbbbb')).toBe('.....');
    expect(worddle('aaaaa').guess('abbbb')).toBe('A....');
    expect(worddle('aaaaa').guess('babbb')).toBe('.A...');
    expect(worddle('aaaaa').guess('bbabb')).toBe('..A..');
    expect(worddle('aaaaa').guess('bbbab')).toBe('...A.');
    expect(worddle('aaaaa').guess('bbbba')).toBe('....A');
});

test('should recognize not well placed letter',  ()=> {
    expect(worddle('abbbb').guess("caccc")).toBe('.a...');
    expect(worddle('abbbb').guess("ccacc")).toBe('..a..');
    expect(worddle('abbbb').guess("cccac")).toBe('...a.');
    expect(worddle('abbbb').guess("cccca")).toBe('....a');
});


test('should favor well placed letter over wrongly placed letter', ()=> {
    expect(worddle('abbbb').guess('accca')).toBe('A....');
    expect(worddle('abbbb').guess('accaa')).toBe('A....');
    expect(worddle('aabbb').guess('accaa')).toBe('A..a.');
    expect(worddle('aabbb').guess('aacaa')).toBe('AA...');
    expect(worddle('aabbb').guess('cccaa')).toBe('...aa');
    expect(worddle('bbabb').guess('aaaaa')).toBe('..A..');
});

