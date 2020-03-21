
fruits = [
"Açaí",
"Akee",
"Apple",
"Apricot",
"Avocado",
"Banana",
"Bilberry",
"Blackberry",
"Blackcurrant",
"Blueberry",
"Boysenberry",
"Currant",
"Cherry",
"Cloudberry",
"Coconut",
"Cranberry",
"Damson",
"Date",
"Durian",
"Elderberry",
"Feijoa",
"Fig",
"Gooseberry",
"Grape",
"Raisin",
"Grapefruit",
"Guava",
"Honeyberry",
"Huckleberry",
"Jabuticaba",
"Jackfruit",
"Jambul",
"Jostaberry",
"Jujube",
"Kiwifruit",
"Kumquat",
"Lemon",
"Lime",
"Loganberry",
"Loquat",
"Longan",
"Lychee",
"Mango",
"Mangosteen",
"Marionberry",
"Melon",
"Cantaloupe",
"Honeydew",
"Watermelon",
"Mulberry",
"Nectarine",
"Nance",
"Orange",
"Clementine",
"Mandarine",
"Tangerine",
"Papaya",
"Passionfruit",
"Peach",
"Pear"
]

import os

i = 0

directory = "pics"

for fileName in os.listdir(directory):
    os.rename(directory + "/" + fileName, directory + "/" + fruits[i] + ".jpg")
    i += 1

print(i)
