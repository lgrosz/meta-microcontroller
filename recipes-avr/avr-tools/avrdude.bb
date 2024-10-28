SUMMARY = "AVRDUDE - AVR Downloader/UploaDEr"
HOMEPAGE = "https://www.nongnu.org/avrdude/"
SECTION = "devel"
LICENSE = "GPL-2.0-or-later"

LIC_FILES_CHKSUM = "file://COPYING;md5=4f51bb496ef8872ccff73f440f2464a8"

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
SRCREV = "e599214c9d602ca5ae3450fc23bdaf4266562282"
S = "${WORKDIR}/git"
PV = "7.3+git${SRCPV}"

RRECOMMENDS:${PN} += "avr-udev-rules"
