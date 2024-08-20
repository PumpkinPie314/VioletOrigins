__config() -> {
   'commands' -> {
    'help' -> _() -> print(player(), 'Changes the author of the book in your hand. Author can be locked so it cannot be changed again in the future.'),
    '<string>'-> _(s) -> setauthor(player(), s, false),
    '<string> lock'-> _(s) -> setauthor(player(), s, true)
   }
};

setauthor(player, name, lock) -> (
   if (query(player, 'holds', 'mainhand') == null, 
      sound('minecraft:block.note_block.didgeridoo', pos(player()));
      print(player, 'hold a written book who\'s author you want to change');
      return()
   );

   slot = player~'selected_slot';
   [item, count, nbt] = inventory_get(player, slot);
   if (item != 'written_book',
      sound('minecraft:block.note_block.didgeridoo', pos(player()));
      print(player, 'hold a written book who\'s author you want to change');
      return()
   );
   if (nbt:'author_locked_by_pumpkins_carpet_script'==true, 
      sound('minecraft:block.note_block.iron_xylophone', pos(player()));
      print(player, 'this book\'s author is locked and can no longer be changed');
      return()
   );
   
   name = '"'+name+'"';//this is needed for authors will spaces in there name. not entirely surly why..
   put(nbt, 'author', name);  //this line does the work
   if (lock,
      (
         sound('minecraft:block.note_block.chime', pos(player()));
         put(nbt, 'author_locked_by_pumpkins_carpet_script', true)
      ),
      //else
      (
         sound('minecraft:block.note_block.cow_bell', pos(player()));
      )
   );
   inventory_set(player, slot, count, item, nbt)
)