__on_player_right_clicks_block(player, item_tuple, hand, block, face, hitvec)->
(
    if(     (inventory_find(player(), null) >= 35) &&
            (player~'gamemode' == 'survival' || player~'gamemode' == 'adventure') && 
            (block_tags(block,'charm:storage_crates') && 
            (query(player, 'sneaking'))),
        
        schedule(0,'remove_charm_storage_crate_duped_items', player);
    )
);
remove_charm_storage_crate_duped_items(player)->(
    run(str('execute positioned ~ ~%d ~ run kill @e[type=item,distance=..1,nbt={PickupDelay:40s}]', player~'eye_height'))
)