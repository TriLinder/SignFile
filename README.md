![icon.png](src/main/resources/assets/signfile/icon_transparent.png)

# SignFile

A simple Minecraft Fabric mod for filling out signs from a .json file.

---

This is my first shot at Java so expect terrible code.

Made for the [LiveOverflow SMP](https://www.youtube.com/playlist?list=PLhixgUqwRTjwvBI-hmbZ2rpkAl4lutnJG) server. See the result [here](https://cdn.discordapp.com/attachments/985597892888764466/1021019127499997244/signs.png).

Made primarily for Minecraft version 1.18.2, however [builds](https://github.com/TriLinder/SignFile/releases/latest) for newer version will be included.

## Setup

[Fabric API](https://modrinth.com/mod/fabric-api/) is required.

Place `signs.json` into your config folder with the following syntax:

```json
{
"48,121,-256": "First line\nSecond line\nThird line\nFourth line",
"47,121,-256": "this\nmod\nis\npretty cool"  
}
```

Then simply place a sign at the correct coordinates in-game.

You can place a sign normally with this mod active by sneaking.
