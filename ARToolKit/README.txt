Read me for ARToolKit.
======================


Contents.
---------

About this archive.
Installing.
Running the examples.
Beginning your own development.
Release notes.
libKPM usage.
Next steps.


About this archive.
-------------------

This archive contains the ARToolKit libraries, utilities and examples, version 5.3.2.

ARToolKit version 5.3.2 is released under the GNU Lesser General Public License version 3, with some additional permissions. Example code is generally released under a more permissive disclaimer; please read the file LICENSE.txt for more information.

ARToolKit is designed to build on Windows, Macintosh OS X, Linux, iOS and Android platforms.

This archive was assembled by:
    Philip Lamb
    http://www.artoolkit.org
    2016-03-23


Installing
----------

ARToolKit is supplied as pre-built binaries for each platform, plus full source code for the SDK libraries, utilities, and examples, and documentation.

  Windows

	Run the ARToolKit installer executable and follow the prompts.
	By default, ARToolKit will be installed into a folder inside your Program Files folder. Start menu items are created to allow you to quickly open the folder containing the installed software, to open a command-line prompt with the path set to this folder, and to read documentation and access this support site. The installer also automatically creates the ARTOOLKIT5_ROOT environment variable to point to your chosen install location.

	If you are upgrading to a newer version, it is generally safe to install over the old version. Before upgrading, save any modifications you have made to any ARToolKit source or example code, and then run the installer. The installer will add or update new files, and remove unneeded old files.
	
  Mac OS X

	The SDK is supplied as an archive file (.tar.gz or .zip file) which need only be unpacked to a location of your choice, e.g. ~/SDKs/. Drop the archive into your chosen location and double-click it in the Finder to unpack it.
	
	Once unpacked, to set the ARTOOLKIT5_ROOT so that other software can find ARToolKit, open a Terminal window, and run the script artoolkit5-setenv: (Example assumes ARToolKit5 is in ~/SDKs/):
	
		cd ~/SDKs/ARToolKit5/
		./share/artoolkit5-setenv

  Linux

	The SDK is supplied as an archive file (.tar.gz) which need only be unpacked to a location of your choice, e.g. ~/SDKs/. Move the archive into your chosen location and use the following command in your terminal to unpack it:
	
		tar xzvf ARToolKit5-bin-*.tar.gz

	Once unpacked, to set the ARTOOLKIT5_ROOT so that other software can find ARToolKit, open a terminal window, and run the script artoolkit5-setenv: (Example assumes ARToolKit5 is in ~/SDKs/):

		cd ~/SDKs/ARToolKit5/
		./share/artoolkit5-setenv


Running the examples
--------------------

ARToolKit includes a variety of examples demonstrating ARToolKit programming techniques. After installation, the executables for these applications can be found in the bin directory inside your ARToolKit directory.
The simpleLite example is the most straightforward example. It can be run to test your ARToolKit installation is functioning correctly.

An explanation of the sourcecode of this example can be found on the page http://www.artoolkit.org/documentation/Examples:example_simplelite. More detailed information about the techniques demonstrated in each example can be found in the documentation.

  Windows:

	simpleLite can be opened by double-clicking its icon in the ARToolKit5\bin directory. Alternately, you can run it from the command line:

	* Open a command-line window (cmd.exe).
	* Navigate to your ARToolKit5\bin directory.
	* Type: simpleLite.exe

  Mac OS X:

	* Bundled applications are generated for the examples. Open the "bin" directory in the Finder and double-click the "simpleLite" example app. Application errors are logged in the Console application.

  Linux:
  
	* simpleLite can be launched from a terminal window thus:
	  First, set the environment variable ARTOOLKIT5_VCONF to indicate the video device to be used;
	  for example, to use a V4L2 camera, do 
	    export ARTOOLKIT5_VCONF="-device=LinuxV4L2"
	    
	    or to use a camera driven via GStreamer, do
	    
	    export ARTOOLKIT5_VCONF="-device=GStreamer"
	    
	    then cd to the bin directory and do
	    
		./simpleLite
		
		
Beginning your own development
------------------------------

In beginning your own development, it is recommended that you create your own project outside the ARToolKit folder, and treat ARToolKit as an external SDK. However, it is also perfectly permissible to begin by modifying one or more of the example applications. ARToolKit is supplied with project files for each supported platform. The project files allow you to rebuild ARToolKit from source, and act as examples of how to structure your own application builds (e.g. required link libraries).

Required external software

  * A supported compiler or IDE is required to use ARToolKit:
  
	Windows: Microsoft Visual Studio 2013 and Microsoft Visual Studio 2010 SP1 are supported. The free Microsoft Visual Studio Express Edition will also work.
	Mac OS X: Xcode tools v5.1 under Mac OS X 10.9 or later is required. Xcode 6 under Mac OS X 10.10 is recommended. Xcode may be obtained free from Apple at http://developer.apple.com/xcode/.
    Linux: g++ with libstdc++, or Clang and LLVM's libc++ are required. For the latter, install Packages: 'clang', 'libc++-dev'.
	
  Where ARToolKit libraries require external DLLs, these are generally supplied with ARToolKit. Exceptions are listed below.

  Windows
    * OpenGL version 1.5 or later is required. This is usually provided by the display drivers, as the base system supports only OpenGL v1.4.
	The optional video capture sources require some external software:
	* QuickTime movie files as video source: QuickTime 6.4 or later must be installed. Download from http://www.apple.com/quicktime/download/.
	* Point Grey camera: The Flycapture SDK (distributed with Point Grey Cameras) must be installed.

  Mac OS X
    * C++ runtime: libc++ is only available on OS X 10.7 and later.
	* OpenSceneGraph (optional; The ARToolKit OSG renderer requires OpenSceneGraph). Use the installer provided at http://www.artoolkit.org/dist/openscenegraph/.

  Linux
	ARToolKit follows the Linux model whereby required software is externally installed. The following packages are required to be installed in your package manager to run the ARToolKit examples. (Additional packages required to build ARToolKit from source are listed on that help page.)
    * C++ runtime: use the standard libstdc++ or install the package 'libc++1'.
	* OpenGL: Package 'xorg'
	* OpenCV (unless building with Clang). Packages: 'libopencv-dev'.
	* GLUT: Package 'freeglut3'. Alternatively, GLUT can be built from source and is also included in the MESA 3D libraries:
	* Video4Linux, lib1394dc, or GStreamer. Packages: 'libv4l2-0', 'libdc1394-22' (for lib1394 version 2.x) or 'libdc1394-13' (for lib1394 version 1.x), and 'libgstreamer0.10'.
	* OpenSceneGraph (optional; The ARToolKit OSG renderer requires OpenSceneGraph). Package 'openscenegraph'.
	* OpenVRML (optional; the ARToolKit VRML renderer requires OpenVRML): Binary deb packages are available from http://www.openvrml.org/.
	
Opening the project files

  Windows
  
	Open the "VisualStudio" directory, then the appropriate directory for your compiler version, and then the "ARToolKit5.sln" solution file.

  Mac OS X

	Open the ARToolKit5.xcodeproj, found inside the Xcode folder.

  Linux

	The SDK build system uses a Configure script and makefiles. To run the script, use this command from a terminal window:

		./Configure



Release notes.
--------------

This release contains ARToolKit v5.3.2.

The major change in ARToolKit v5.3 was a new version of libKPM based on the FREAK detector framework, contributed by DAQRI. See "libKPM usage" below.

Please see the ChangeLog.txt for details of changes in this and earlier releases.

ARToolKit v5.2 was the first major release under an open source license in several years, and represented several years of commercial development of ARToolKit by ARToolworks during this time. It was a significant change to previous users of ARToolKit v2.x. Please see http://www.artoolkit.org/documentation/ARToolKit_feature_comparison for more information.

For users of ARToolKit Professional versions 4.0 through 5.1.7, ARToolKit v5.2 and later include a number of changes. Significantly, full source is now provided for the NFT libraries libAR2 and libKPM.


libKPM usage.
-------------

libKPM, which performs key-point matching for NFT page recognition and initialization now use a FREAK detector framework, contributed by DAQRI. Unlike the previous commercial version of libKPM which used SURF features, FREAK is not encumbered by patents. libKPM now joins the other core ARToolKit libraries under an LGPLv3 license. Additionally the new libKPM no longer has dependencies on OpenCV’s FLANN library, which should simply app builds and distribution on all supported platforms.

Existing holders of a commercial license to ARToolKit Professional v5.x may use libKPM from ARToolKit v5.2 under the terms of their current license for the remainder of its duration. Please contact us via http://www.artoolkit.org/contact if you are an existing user of ARToolKit Professional with questions.


Next steps.
-----------

We have made a forum for discussion of ARToolKit for Desktop development available on our community website.

http://www.artoolkit.org/community/forums/viewforum.php?f=29

You are invited to join the forum and contribute your questions, answers and success stories.

ARToolKit consists of a full ecosystem of SDKs for desktop, web, mobile and in-app plugin augmented reality. Stay up to date with information and releases from artoolkit.org by joining our announcements mailing list.

http://www.artoolkit.org/community/lists/


Do you have a feature request, bug report, or other code you would like to contribute to ARToolKit? Access the complete source and issue tracker for ARToolKit at http://github.com/artoolkit/artoolkit5

--
EOF
