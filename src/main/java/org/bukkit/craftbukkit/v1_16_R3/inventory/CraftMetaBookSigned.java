package org.bukkit.craftbukkit.v1_16_R3.inventory;

import java.util.Map;

import com.google.common.collect.ImmutableMap.Builder;
import org.bukkit.Material;
import org.bukkit.configuration.serialization.DelegateDeserialization;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftMetaItem.SerializableMeta;
import org.bukkit.craftbukkit.v1_16_R3.util.CraftChatMessage;
import org.bukkit.inventory.meta.BookMeta;

import net.minecraft.nbt.CompoundNBT;

@DelegateDeserialization(SerializableMeta.class)
class CraftMetaBookSigned extends CraftMetaBook implements BookMeta {

    CraftMetaBookSigned(CraftMetaItem meta) {
        super(meta);
    }

    CraftMetaBookSigned(CompoundNBT tag) {
        super(tag);
    }

    CraftMetaBookSigned(Map<String, Object> map) {
        super(map);
    }

    protected String deserializePage(String pageData) {
        return CraftChatMessage.fromJSONOrStringToJSON(pageData, false, true, MAX_PAGE_LENGTH, false);
    }

    @Override
    protected String convertPlainPageToData(String page) {
        return CraftChatMessage.fromStringToJSON(page, true);
    }

    @Override
    protected String convertDataToPlainPage(String pageData) {
        return CraftChatMessage.fromJSONComponent(pageData);
    }

    @Override
    void applyToItem(CompoundNBT itemData) {
        super.applyToItem(itemData);
    }

    @Override
    boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    boolean applicableTo(Material type) {
        switch (type) {
        case WRITTEN_BOOK:
        case WRITABLE_BOOK:
            return true;
        default:
            return false;
        }
    }

    @Override
    public CraftMetaBookSigned clone() {
        CraftMetaBookSigned meta = (CraftMetaBookSigned) super.clone();
        return meta;
    }

    @Override
    int applyHash() {
        final int original;
        int hash = original = super.applyHash();
        return original != hash ? CraftMetaBookSigned.class.hashCode() ^ hash : hash;
    }

    @Override
    boolean equalsCommon(CraftMetaItem meta) {
        return super.equalsCommon(meta);
    }

    @Override
    boolean notUncommon(CraftMetaItem meta) {
        return super.notUncommon(meta) && (meta instanceof CraftMetaBookSigned || isBookEmpty());
    }

    @Override
    Builder<String, Object> serialize(Builder<String, Object> builder) {
        super.serialize(builder);
        return builder;
    }
}