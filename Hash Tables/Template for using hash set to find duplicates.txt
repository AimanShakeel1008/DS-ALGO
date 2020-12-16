/*
 * Template for using hash set to find duplicates.
 */
boolean findDuplicates(List<Type> keys) {
    // Replace Type with actual type of your key
    Set<Type> hashset = new HashSet<>();
    for (Type key : keys) {
        if (hashset.contains(key)) {
            return true;
        }
        hashset.add(key);
    }
    return false;
}
