val value = "BBFFBBFRLL"
val str = value.replace("B", "1")
    .replace("R", "1")
    .replace("F", "0")
    .replace("L", "0").toByte().toInt(2)

//