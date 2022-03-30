#reoves the kelp which usually appears after the generation of an event



execute at @e[tag=ercerus,tag=remove_kelp] run kill @e[type=item,nbt={Item:{id:"minecraft:kelp"}}]
kill @e[tag=ercerus,tag=remove_kelp]