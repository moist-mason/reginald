package com.github.moistmason.reginald.building

class BuildConstants {
    public static final def JAVA_VERSION = '21'
    public static final def MINECRAFT_VERSION = '1.21.1'
    public static final def MINECRAFT_VERSION_RANGE = '[' + MINECRAFT_VERSION + ']'

    public static final def NEO_VERSION = '21.1.219'
    public static final def LOADER_VERSION_RANGE = '[1,)'
    public static final def PARCHMENT_VERSION = '2024.11.17' // 1.21.1 only

    public static final def MOD_GROUP = 'com.github.moistmason'
    public static final def MOD_ID = 'reginald'
    public static final def MOD_NAME = 'Reginald'
    public static final def MOD_LICENSE = 'MIT License'
    public static final def MOD_VERSION = getModSnapshotVersion('0.1.0', '1')

    static def getModVersion(String root) {
        return String.join('-', root, MINECRAFT_VERSION)
    }

    static def getModSnapshotVersion(String root, String snapshot) {
        return String.join('-', root, 'snapshot', snapshot, MINECRAFT_VERSION)
    }
}
