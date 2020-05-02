/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YTDL;

import java.util.ArrayList;

/**
 *
 * @author JoshuaSL
 */
public class QSelection {

    ArrayList<Integer> audioVideoCode = null;
    private int formatCode;

    public void initialize() {
        audioVideoCode = new ArrayList<>();
        audioVideoCode.add(0, 0);
        audioVideoCode.add(1, 139); //139	m4a	audio	48k 
        audioVideoCode.add(2, 140); //140	m4a	audio	128k 
        audioVideoCode.add(3, 141); //141	m4a	audio	256k 
        audioVideoCode.add(4, 171); //171	webm	audio	128k 
        audioVideoCode.add(5, 249); //249	webm	audio	50k 
        audioVideoCode.add(6, 250); //250	webm	audio	70k 
        audioVideoCode.add(7, 133); //133	mp4	video	240p 
        audioVideoCode.add(8, 134); //134	mp4	video	360p 
        audioVideoCode.add(9, 135); //135	mp4	video	480p 
        audioVideoCode.add(10, 136); //136	mp4	video	720p 
        audioVideoCode.add(11, 137); //137	mp4	video	1080p 
        audioVideoCode.add(12, 138); //138	mp4	video	2160p60 
        audioVideoCode.add(13, 160); //160	mp4	video	144p 
        audioVideoCode.add(14, 264); //264	mp4	video	1440p 
        audioVideoCode.add(15, 266); //266	mp4	video	2160p60 
        audioVideoCode.add(16, 298); //298	mp4	video	720p60 
        audioVideoCode.add(17, 299); //299	mp4	video	1080p60 
        audioVideoCode.add(18, 167); //167	webm	video	360p 
        audioVideoCode.add(19, 168); //168	webm	video	480p 
        audioVideoCode.add(20, 169); //169	webm	video	1080p 
        audioVideoCode.add(21, 218); //218	webm	video	480p 
        audioVideoCode.add(22, 219); //219	webm	video	144p 
        audioVideoCode.add(23, 242); //242	webm	video	240p 
        audioVideoCode.add(24, 243); //243	webm	video	360p 
        audioVideoCode.add(25, 244); //244	webm	video	480p 
        audioVideoCode.add(26, 245); //245	webm	video	480p 
        audioVideoCode.add(27, 246); //246	webm	video	480p 
        audioVideoCode.add(28, 247); //247	webm	video	720p 
        audioVideoCode.add(29, 248); //248	webm	video	1080p 
        audioVideoCode.add(30, 271); //271	webm	video	1440p 
        audioVideoCode.add(31, 272); //272	webm	video	4320p 
        audioVideoCode.add(32, 278); //278	webm	video	144p 
        audioVideoCode.add(33, 302); //302	webm	video	720p60 
        audioVideoCode.add(34, 303); //303	webm	video	1080p60 
        audioVideoCode.add(35, 308); //308	webm	video	1440p60 
        audioVideoCode.add(36, 313); //313	webm	video	2160p 
        audioVideoCode.add(37, 315); //315	webm	video	2160p60 
        audioVideoCode.add(38, 330); //330	webm	video	144p60 hdr
        audioVideoCode.add(39, 331); //331	webm	video	240p60 hdr
        audioVideoCode.add(40, 332); //332	webm	video	360p60 hdr
        audioVideoCode.add(41, 333); //333	webm	video	480p60 hdr
        audioVideoCode.add(42, 334); //334	webm	video	720p60 hdr
        audioVideoCode.add(43, 335); //335	webm	video	1080p60 hdr
        audioVideoCode.add(44, 336); //336	webm	video	1440p60 hdr
        audioVideoCode.add(45, 337); //337	webm	video	2160p60 hdr
        audioVideoCode.add(46, 17); //17	3gp	audio/video	144p
        audioVideoCode.add(47, 36); //36	3gp	audio/video	180p
        audioVideoCode.add(48, 5); //  5	flv	audio/video	240p
        audioVideoCode.add(49, 6); //  6	flv	audio/video	270p
        audioVideoCode.add(50, 34); //34	flv	audio/video	360p
        audioVideoCode.add(51, 35); //35	flv	audio/video	480p
        audioVideoCode.add(52, 92); //92	hls	audio/video	240p  3D
        audioVideoCode.add(53, 93); //93	hls	audio/video	360p  3D
        audioVideoCode.add(54, 94); //94	hls	audio/video	480p  3D
        audioVideoCode.add(55, 95); //95	hls	audio/video	720p  3D
        audioVideoCode.add(56, 96); //96	hls	audio/video	1080p
        audioVideoCode.add(57, 132); //132	hls	audio/video	240p
        audioVideoCode.add(58, 151); //151	hls	audio/video	72p
        audioVideoCode.add(59, 18); //18	mp4	audio/video	360p
        audioVideoCode.add(60, 22); //22	mp4	audio/video	720p
        audioVideoCode.add(61, 37); //37	mp4	audio/video	1080p
        audioVideoCode.add(62, 38); //38	mp4	audio/video	3072p
        audioVideoCode.add(63, 82); //82	mp4	audio/video	360p  3D
        audioVideoCode.add(64, 83); //83	mp4	audio/video	480p  3D
        audioVideoCode.add(65, 84); //84	mp4	audio/video	720p  3D
        audioVideoCode.add(66, 85); //85	mp4	audio/video	1080p  3D
        audioVideoCode.add(67, 43); //43	webm	audio/video	360p
        audioVideoCode.add(68, 44); //44	webm	audio/video	480p
        audioVideoCode.add(69, 45); //45	webm	audio/video	720p
        audioVideoCode.add(70, 46); //46	webm	audio/video	1080p
        audioVideoCode.add(71, 100); //100	webm	audio/video	360p  3D
        audioVideoCode.add(72, 101); //101	webm	audio/video	480p  3D
        audioVideoCode.add(73, 102); //102	webm	audio/video	720p  3D

    }

    /**
     * @param index from the selection of an item in the list
     * @return the formatCode
     */
    public int getFormatCode(int index) {

        this.formatCode = audioVideoCode.get(index);

        return formatCode;
    }

}
