package edigest.journalApp.controller;

import edigest.journalApp.Entry.JournalEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private Map<Integer, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());


    }
    @PostMapping
    public Boolean CreateEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(),myEntry);
        return true;

    }
    @GetMapping("id/{myId}")
   public JournalEntry getJournalEntryById (@PathVariable int myId){
       return journalEntries.get(myId);
   //@GetMapping("/id/{myId}")
   //public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable int myId) {
       //if (myId < 0 || myId >= journalEntries.size()) {
           //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
       //}
       //JournalEntry entry = journalEntries.get(myId);
       //return ResponseEntity.ok(entry);
   }




    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById (@PathVariable int myId) {
        return journalEntries.remove(myId);


    }
    @PutMapping("/id/{id}")
    public JournalEntry updateJournalEntryById (@PathVariable int id,@RequestBody JournalEntry myEntry){
        return journalEntries.put(id,myEntry);

    }

}
