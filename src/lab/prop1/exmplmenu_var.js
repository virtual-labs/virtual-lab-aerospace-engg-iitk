/***********************************************************************************
*       (c) Ger Versluis 2000 version 5.41 24 December 2001               *
*       For info write to menus@burmees.nl                        *
*       You may remove all comments for faster loading            *             
***********************************************************************************/

	var NoOffFirstLineMenus=6;                      // Number of first level items
	var LowBgColor='000000';                        // Background color when mouse is not over
	var LowSubBgColor='007799';                       // Background color when mouse is not over on subs
	var HighBgColor='007799';                         // Background color when mouse is over
	var HighSubBgColor='black';                     // Background color when mouse is over on subs
	var FontLowColor='yellow';                      // Font color when mouse is not over
	var FontSubLowColor='white';                   // Font color subs when mouse is not over
	var FontHighColor='white';                        // Font color when mouse is over
	var FontSubHighColor='white';                   // Font color subs when mouse is over
	var BorderColor='white';                        // Border color
	var BorderSubColor='009999';                     // Border color for subs
	var BorderWidth=1;                              // Border width
	var BorderBtwnElmnts=1;                         // Border between elements 1 or 0
	var FontFamily="arial,comic sans ms,technical"  // Font family menu items
	var FontSize=12;                                 // Font size menu items
	var FontBold=1;                                 // Bold menu items 1 or 0
	var FontItalic=0;                               // Italic menu items 1 or 0
	var MenuTextCentered='center';                    // Item text position 'left', 'center' or 'right'
	var MenuCentered='center';                      // Menu horizontal position 'left', 'center' or 'right'
	var MenuVerticalCentered='top';                 // Menu vertical position 'top', 'middle','bottom' or static
	var ChildOverlap=.1;                            // horizontal overlap child/ parent
	var ChildVerticalOverlap=.1;                    // vertical overlap child/ parent
	var StartTop=270;                               // Menu offset x coordinate
	var StartLeft=0;                                // Menu offset y coordinate
	var VerCorrect=0;                               // Multiple frames y correction
	var HorCorrect=0;                               // Multiple frames x correction
	var LeftPaddng=0;                               // Left padding
	var TopPaddng=10;                                // Top padding
	var FirstLineHorizontal=0;                      // SET TO 1 FOR HORIZONTAL MENU, 0 FOR VERTICAL
	var MenuFramesVertical=1;                       // Frames in cols or rows 1 or 0
	var DissapearDelay=1000;                        // delay before menu folds in
	var TakeOverBgColor=1;                          // Menu frame takes over background color subitem frame
	var FirstLineFrame='navig';                     // Frame where first level appears
	var SecLineFrame='space';                       // Frame where sub levels appear
	var DocTargetFrame='space';                     // Frame where target documents appear
	var TargetLoc='';                               // span id for relative positioning
	var HideTop=0;                                  // Hide first level when loading new document 1 or 0
	var MenuWrap=1;                                 // enables/ disables menu wrap 1 or 0
	var RightToLeft=0;                              // enables/ disables right to left unfold 1 or 0
	var UnfoldsOnClick=0;                           // Level 1 unfolds onclick/ onmouseover
	var WebMasterCheck=0;                           // menu tree checking on or off 1 or 0
	var ShowArrow=0;                                // Uses arrow gifs when 1
	var KeepHilite=1;                               // Keep selected path highligthed
	var Arrws=['tri.gif',5,10,'tridown.gif',10,5,'trileft.gif',5,10];

function BeforeStart(){return}
function AfterBuild(){return}
function BeforeFirstOpen(){return}
function AfterCloseAll(){return}


// Menu tree
//      MenuX=new Array(Text to show, Link, background image (optional), number of sub elements, height, width);
//      For rollover images set "Text to show" to:  "rollover:Image1.jpg:Image2.jpg"



Menu1=new Array("Objective","object.html","",0,40,250);

Menu2=new Array("Introduction","intro.html","",0,40,250); 

Menu3=new Array("Apparatus & Procedure","ap.html","",0,40,250);
	
Menu4=new Array("Results & Discussion ","results.html","",0,40,250);
	
Menu5=new Array("Appendix","appendix.html","",0,40,250);

Menu6=new Array("Gallery","","",2,40,250);
	Menu6_1=new Array("video1","mov1.htm","",0,30,200);
	Menu6_2=new Array("video2","mov2.htm","",0,30,200);
	




