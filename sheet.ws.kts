val value = "#ab12d3"
value matches "#[0-9,a-f]{6}".toRegex()