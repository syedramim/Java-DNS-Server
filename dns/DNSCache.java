package dns;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class representing a cache of stored DNS records.
 *
 * @version 1.0
 */
public class DNSCache {
    
    private ArrayList<ArrayList<DNSRecord>> cache;
    
    public DNSCache(){
        cache = new ArrayList<ArrayList<DNSRecord>>();
    }
    
    public void addRecord(ArrayList<DNSRecord> record){
        cache.add(record);
    }
    
    public ArrayList<DNSRecord> returnRecords(String name, String type, String rclass){
        var matches = new ArrayList<DNSRecord>();
        for(var r: cache){
            for(var record: r){
                if(record.getName().equals(name) && record.getClassStr().equals(rclass) && record.getTypeStr().equals(type)){
                    matches.add(record);
                }
            }
        }
        return matches;
    }
    
    public void cleanCache(){
        for(var r: cache){
            for(var record: r){
                if(record.getTTL() < record.getTimeStamp()){
                    cache.remove(record);
                }
            }
        }
    }
}
