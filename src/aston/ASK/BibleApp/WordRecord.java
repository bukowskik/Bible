package aston.ASK.BibleApp;

import java.util.LinkedList;

public final class WordRecord
{

    public final class WordLocation
    {
        public final WordRecord wr;
        public final Book book;
        public final int chapter;
        public final int verse;
        
        private WordLocation(WordRecord wr, Book book, int chapter, int verse)
        {
            this.wr = wr;
            this.book = book;
            this.chapter = chapter;
            this.verse = verse;
        }
        
        final public boolean equals(WordLocation wl)
        {
            return (wl.wr == wr && wl.book.equals(this.book) && wl.chapter == this.chapter && wl.verse == this.verse);
        }
    }
    
    private final String word;
    private LinkedList<WordLocation> appearances;
    
    public WordRecord(String word)
    {
        this.word = word.toLowerCase();
        this.appearances = new LinkedList<WordLocation>();
    }
    
    public final void record(Book book, int chapter, int verse)
    {
        WordLocation wl = new WordLocation(this, book, chapter, verse);
        appearances.add(wl);
    }
    
    public final String getWord()
    {
        return word;
    }
    
    public final WordLocation[] getAppearances()
    {
        return appearances.toArray(new WordLocation[appearances.size()]); 
    }

    @Override
    public String toString()
    {
        return String.format("%s: %d", word, appearances.size());
    }
    
}
