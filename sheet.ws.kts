val expectedFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
val str = "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd byr:1937 iyr:2017 cid:147 hgt:183cm"
val arr = str.split(" ")
expectedFields.contains(arr[0].substring(0, 3))