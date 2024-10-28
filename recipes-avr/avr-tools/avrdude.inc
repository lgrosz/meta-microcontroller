SUMMARY = "AVRDUDE - AVR Downloader/UploaDEr"
HOMEPAGE = "https://www.nongnu.org/avrdude/"
SECTION = "devel"
LICENSE = "GPL-2.0-or-later"

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit cmake gettext

# Do we need libhid?
DEPENDS = " \
    bison-native \
    flex \
    elfutils \
    libusb1 \
    libftdi \
    hidapi \
"

PACKAGECONFIG ??= ""

PACKAGECONFIG[linuxgpio] = " \
    -DHAVE_LINUXGPIO=ON, \
    -DHAVE_LINUXGPIO=OFF, \
    libgpiod,,,"

PACKAGECONFIG[linuxspi] = " \
    -DHAVE_LINUXSPI=ON, \
    -DHAVE_LINUXSPI=OFF,,,,"

PACKAGECONFIG[parport] = " \
    -DHAVE_PARPORTSPI=ON, \
    -DHAVE_PARPORTSPI=OFF,,,,"

SRC_URI = "git://github.com/avrdudes/avrdude.git;protocol=https;branch=main"
S = "${WORKDIR}/git"

RRECOMMENDS:${PN} += "avr-udev-rules"
