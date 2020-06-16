class Day16_ValidateIPAddress {
    public String validIPAddress(String IP) {
        if (isIP4(IP))
            return "IPv4";
        else if (isIP6(IP))
            return "IPv6";
        else
            return "Neither";
    }
    
    private boolean isIP4(String IP) {
        
         if (IP.length() == 0 || IP.substring(0,1).equals(".") || IP.substring(IP.length() - 1, IP.length()).equals("."))
            return false;

        String subnets[] = IP.split("\\.");
        
        if (subnets.length != 4)
            return false;
        
        for (int i=0; i<subnets.length; i++) {
            
            if (subnets[i].length() <1 || subnets[i].length() > 3  || (subnets[i].length() > 1 && subnets[i].substring(0, 1).equals("0")))
                return false;
            try {
                if (subnets[i].substring(0,1).equals("-"))
                    return false;
                int val = Integer.parseInt(subnets[i]);
                
                if (val < 0 || val > 255) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        
        return true;
    } 
    
    private boolean isIP6(String IP) {
        if (IP.length() == 0 || IP.substring(0,1).equals(":") || IP.substring(IP.length() - 1, IP.length()).equals(":"))
            return false;
        String octets[] = IP.split(":");
        
        if (octets.length != 8)
            return false;
        
        for (int i=0; i<octets.length; i++) {
            
            if (octets[i].length() <1 || octets[i].length() > 4)
                return false;
            
            try {
                if (octets[i].substring(0,1).equals("-"))
                    return false;
                // Parsing with base 16 hexadecimal to integer.
                int val = Integer.parseInt(octets[i], 16);
                
            } catch (Exception e) {
                return false;
            }
        }
        
        return true;
    }
}