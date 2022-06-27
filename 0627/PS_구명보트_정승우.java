<!DOCTYPE html>
<!-- saved from url=(0056)https://programmers.co.kr/learn/courses/30/lessons/42885 -->
<html lang="ko" xml:lang="ko" xmlns="http://www.w3.org/1999/xhtml" class="" translate=""><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<meta name="twitter:title" property="og:title" itemprop="title name" content="코딩테스트 연습 - 구명보트">
<meta name="og:title" property="og:title" itemprop="title name" content="코딩테스트 연습 - 구명보트">
<meta name="twitter:image" property="og:image" itemprop="image primaryImageOfPage" content="https://image.freepik.com/free-vector/landing-page-template-for-a-website_23-2147782747.jpg">
<meta name="og:image" property="og:image" itemprop="image primaryImageOfPage" content="https://image.freepik.com/free-vector/landing-page-template-for-a-website_23-2147782747.jpg">
<meta name="twitter:url" property="og:url" content="https://programmers.co.kr/learn/courses/30/lessons/42885">
<meta name="og:url" property="og:url" content="https://programmers.co.kr/learn/courses/30/lessons/42885">

<title>코딩테스트 연습 - 구명보트 | 프로그래머스</title>
<link rel="shortcut icon" type="image/x-icon" href="https://programmers.co.kr/assets/icons/favicon-40b78633b6556a68c3da8e2125c31512fbd01d09906ab76c8a8ff289e494cadb.png">
<link rel="apple-touch-icon" type="image/png" href="https://programmers.co.kr/assets/icons/apple-icon-6eafc2c4c58a21aef692d6e44ce99d41f999c71789f277317532d0a9c6db8976.png">
<meta name="keywords" content="코딩 교육, 코딩, 프로그래밍, 실습, 생활코딩, 알고리즘, java">
<meta property="fb:app_id" content="339079816467879">
<meta property="og:type" content="website">
<meta property="og:site_name" content="프로그래머스">
<meta name="twitter:card" content="summary">
<meta name="image" content="https://image.freepik.com/free-vector/landing-page-template-for-a-website_23-2147782747.jpg">
<meta name="csrf-param" content="authenticity_token">
<meta name="csrf-token" content="9rhVSXOjb5vgX-obOBvIXoNS9XnOh1Pvmqq02fEEw52WqBeI3kY2uYhWjmmH5BL_ykNjFr3xKhES2VF1LvSGfg">
<meta name="action-cable-url" content="wss://ws.programmers.co.kr:443/cable">

  <link rel="stylesheet" media="all" href="./PS_구명보트_정승우_files/library-fe9e90ce8aed3008e678f89cd0f9ff2d1cc5c19e816756ee8167baeecc5faa7a.css" debug="false">
  <link rel="stylesheet" media="all" href="./PS_구명보트_정승우_files/application-2ea3eacad4fb9527f6f4c9a24e44f265e4a6b03b6436e769bd92c8055d858267.css">
  


  <!-- Google Tag Manager -->
<script src="./PS_구명보트_정승우_files/2050250308523590" async=""></script><script async="" src="./PS_구명보트_정승우_files/fbevents.js.다운로드"></script><script type="text/javascript" async="" src="./PS_구명보트_정승우_files/analytics.js.다운로드"></script><script async="" src="./PS_구명보트_정승우_files/gtm.js.다운로드"></script><script>(function (w, d, s, l, i) {
  w[l] = w[l] || [];
  w[l].push({
    'gtm.start':
      new Date().getTime(), event: 'gtm.js'
  });
  var f = d.getElementsByTagName(s)[0],
    j = d.createElement(s), dl = l != 'dataLayer' ? '&l=' + l : '';
  j.async = true;
  j.src =
    'https://www.googletagmanager.com/gtm.js?id=' + i + dl;
  f.parentNode.insertBefore(j, f);
})(window, document, 'script', 'dataLayer', 'GTM-NT8HLJD');</script>
<!-- End Google Tag Manager -->



<style type="text/css">.cloudinary-thumbnails { list-style: none; margin: 10px 0; padding: 0 } .cloudinary-thumbnails:after { clear: both; display: block; content: '' } .cloudinary-thumbnail { float: left; padding: 0; margin: 0 15px 5px 0; display: none } .cloudinary-thumbnail.active { display: block } .cloudinary-thumbnail img { border: 1px solid #01304d; border-radius: 2px; -moz-border-radius: 2px; -webkit-border-radius: 2px } .cloudinary-thumbnail span { font-size: 11px; font-family: Arial, sans-serif; line-height: 14px; border: 1px solid #aaa; max-width: 150px; word-wrap: break-word; word-break: break-all; display: inline-block; padding: 3px; max-height: 60px; overflow: hidden; color: #999; } .cloudinary-delete { vertical-align: top; font-size: 13px; text-decoration: none; padding-left: 2px; line-height: 8px; font-family: Arial, sans-serif; color: #01304d }.cloudinary-button { color: #fefeff; text-decoration: none; font-size: 18px; line-height: 28px; height: 28x; border-radius: 6px; -moz-border-radius: 6px; -webkit-border-radius: 6px; font-weight: normal; text-decoration: none;   display: inline-block; padding: 4px 30px 4px 30px; background: #0284cf; font-family: Helvetica, Arial, sans-serif;   background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMCUiIHgyPSIwJSIgeTI9IjEwMCUiPgogICAgPHN0b3Agb2Zmc2V0PSIwJSIgc3RvcC1jb2xvcj0iIzAyODRjZiIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjEwMCUiIHN0b3AtY29sb3I9IiMwMjU5OGIiIHN0b3Atb3BhY2l0eT0iMSIvPgogIDwvbGluZWFyR3JhZGllbnQ+CiAgPHJlY3QgeD0iMCIgeT0iMCIgd2lkdGg9IjEiIGhlaWdodD0iMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);   background: -moz-linear-gradient(top,  #0284cf 0%, #02598b 100%);   background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#0284cf), color-stop(100%,#02598b));   background: -webkit-linear-gradient(top,  #0284cf 0%,#02598b 100%);   background: -o-linear-gradient(top,  #0284cf 0%,#02598b 100%);   background: -ms-linear-gradient(top,  #0284cf 0%,#02598b 100%);   background: linear-gradient(to bottom,  #0284cf 0%,#02598b 100%);   filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#0284cf', endColorstr='#02598b',GradientType=0 ); }.cloudinary-button:hover { background: #02598b;   background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMCUiIHgyPSIwJSIgeTI9IjEwMCUiPgogICAgPHN0b3Agb2Zmc2V0PSIwJSIgc3RvcC1jb2xvcj0iIzAyNTk4YiIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjEwMCUiIHN0b3AtY29sb3I9IiMwMjg0Y2YiIHN0b3Atb3BhY2l0eT0iMSIvPgogIDwvbGluZWFyR3JhZGllbnQ+CiAgPHJlY3QgeD0iMCIgeT0iMCIgd2lkdGg9IjEiIGhlaWdodD0iMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);   background: -moz-linear-gradient(top,  #02598b 0%, #0284cf 100%);   background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#02598b), color-stop(100%,#0284cf));   background: -webkit-linear-gradient(top,  #02598b 0%,#0284cf 100%);   background: -o-linear-gradient(top,  #02598b 0%,#0284cf 100%);   background: -ms-linear-gradient(top,  #02598b 0%,#0284cf 100%);   background: linear-gradient(to bottom,  #02598b 0%,#0284cf 100%);   filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#02598b', endColorstr='#0284cf',GradientType=0 ); </style></head>
<body class="learn-lessons learn-lessons-show" data-ns="Learn" data-controller="lessons" data-action="show" data-defaultlocale="ko" data-locale="ko">



  <div class="navbar navbar-dark navbar-expand-lg navbar-application navbar-breadcrumb">
  <a class="navbar-brand" href="https://programmers.co.kr/">
    <img alt="logo" width="24" src="./PS_구명보트_정승우_files/bi-symbol-light-49a242793b7a8b540cfc3489b918e3bb2a6724f1641572c14c575265d7aeea38.png">
</a>  <ol class="breadcrumb"><li><a href="https://programmers.co.kr/learn/challenges">코딩테스트 연습</a></li><li><a href="https://programmers.co.kr/learn/courses/30/parts/12244">탐욕법(Greedy)</a></li><li class="active">구명보트</li></ol>

    <div class="navbar-collapse collapse">
      <ul class="nav navbar-nav ml-auto">
        <li class="nav-item"><a onclick="Learn.lessons.challengeable.startTour(true)" class="nav-link" id="help" href="https://programmers.co.kr/learn/courses/30/lessons/42885#">도움말</a></li>
        <li class="nav-item"><a class="nav-link" data-remote="true" href="https://programmers.co.kr/compile_options">컴파일 옵션</a></li>
      </ul>
    </div>
</div>



<div class="main theme-dark">
  
  <div class="lesson-content" data-course-slug="알고리즘-연습" data-course-id="30" data-lesson-id="42885" data-lesson-type="Challenge" data-next-lesson-id="">

    

<ul class="challenge-nav nav nav-tabs nav-tabs-dark task-tab" id="tab" role="tablist">
  <li class="nav-item algorithm-nav-link algorithm-title">
    구명보트
  </li>

  
<div class="challenge-settings nav-item">
    <div class="btn-group-theme btn-group btn-group-toggle" data-toggle="buttons">
        <label class="btn btn-sm btn-outline-dark active">
          <input type="radio" name="themes" autocomplete="off" checked="" data-toggle="button" data-theme="dark">dark
        </label>
        <label class="btn btn-sm btn-outline-dark">
          <input type="radio" name="themes" autocomplete="off" data-toggle="button" data-theme="light">light
        </label>
    </div>

      <div data-toggle="popover" data-trigger="hover" data-placement="bottom" data-content="코드 에디터의 단축키를 설정하는 옵션입니다. 선호하는 에디터 옵션이 없다면 sublime을 선택해주세요." data-original-title="" title="">
        <div class="btn-group-keymap btn-group btn-group-toggle" data-toggle="buttons">
            <label class="btn btn-sm btn-outline-dark active">
              <input type="radio" name="keymaps" autocomplete="off" checked="" data-keymap="sublime">sublime
            </label>
            <label class="btn btn-sm btn-outline-dark">
              <input type="radio" name="keymaps" autocomplete="off" data-keymap="vim">vim
            </label>
            <label class="btn btn-sm btn-outline-dark">
              <input type="radio" name="keymaps" autocomplete="off" data-keymap="emacs">emacs
            </label>
        </div>
      </div>

    <div class="dropdown-language" id="tour7">
      <button class="btn btn-sm btn-dark dropdown-toggle" type="button" data-toggle="dropdown">
        Java
      </button>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="https://programmers.co.kr/learn/courses/30/lessons/42885?language=cpp">C++</a>
            <a class="dropdown-item" href="https://programmers.co.kr/learn/courses/30/lessons/42885?language=java">Java</a>
            <a class="dropdown-item" href="https://programmers.co.kr/learn/courses/30/lessons/42885?language=javascript">JavaScript</a>
            <a class="dropdown-item" href="https://programmers.co.kr/learn/courses/30/lessons/42885?language=python3">Python3</a>
        </div>
    </div>


  <div class="connection-box connection-status js-connection-status-alert connected">
    <svg class="ic-18"><use xlink:href="/assets/svg-defs-341d4ba94dd8e524df08f8b99cf75ce069f44d8f54369ef0fac3ac290d0a7a0d.svg#ic-power-off"></use></svg>
    <span class="connection-status-txt">네트워크 연결 끊김</span>
  </div>
</div>

</ul>

<div class="challenge-content lesson-algorithm-main-section " data-challengeable-id="2540" data-challengeable-type="algorithm" data-algorithm-type="standard" data-language="java" data-user-id="144090" data-interface-type="function">
    

<div class="main-section">
  <div class="guide-section" id="tour2" style="width: calc(40% - 12px);">
    <div class="guide-section-description">
      <h6 class="guide-section-title">문제 설명</h6>
      <div class="markdown solarized-dark"><p>무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 구명보트는 작아서 한 번에 최대 <strong>2명</strong>씩 밖에 탈 수 없고, 무게 제한도 있습니다.</p>

<p>예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg이라면 2번째 사람과 4번째 사람은 같이 탈 수 있지만 1번째 사람과 3번째 사람의 무게의 합은 150kg이므로 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.</p>

<p>구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.</p>

<p>사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.</p>

<h5>제한사항</h5>

<ul>
<li>무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.</li>
<li>각 사람의 몸무게는 40kg 이상 240kg 이하입니다.</li>
<li>구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.</li>
<li>구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.</li>
</ul>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>people</th>
<th>limit</th>
<th>return</th>
</tr>
</thead>
        <tbody><tr>
<td>[70, 50, 80, 50]</td>
<td>100</td>
<td>3</td>
</tr>
<tr>
<td>[70, 80, 50]</td>
<td>100</td>
<td>3</td>
</tr>
</tbody>
      </table></div>
    </div>

  </div>
  <div class="gutter gutter-horizontal" style="width: 24px; background-image: url(&quot;/assets/img-grippie-vertical-86e641691e88be56a100b80e3d437ae6effea08c189fdbdb2396825486763a15.png&quot;);"></div><div class="run-section" style="width: calc(60% - 12px);">
    <div id="tour3" class="code-section" onkeyup="Hera.tryoutChallenges.resizeEditor(this);" style="height: calc(60% - 7px);">
      <div class="editor">
        <ul class="nav nav-pills editor-nav-pills tap-form">
    <input type="hidden" name="initial_code_7546" id="initial_code_7546" value="class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        return answer;
    }
}">
    <input id="7546" data-type="code" data-language="java" type="hidden" value="import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int lt = 0;
        int rt = people.length-1;
        
        while(true) {
            if(lt&gt;rt) {
                break;
            }
            if(lt==rt) {
                answer++;
                break;
            }
            if(people[lt]+people[rt]&gt;limit) {
                answer++;
                rt--;   
            }else if (people[lt]+people[rt]&lt;=limit) {
                answer++;
                lt++;
                rt--;
            }
  
        }
        
        
        
        return answer;

    }
    

}">
    <li class="nav-item">
      <a href="https://programmers.co.kr/learn/courses/30/lessons/42885#" class="btn-tab nav-link active" data-id="7546" data-language="java">
        Solution.java </a>
    </li>
</ul>
        
          <textarea hidden="" id="code" name="code" style="display: none;">import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int lt = 0;
        int rt = people.length-1;
        
        while(true) {
            if(lt&gt;rt) {
                break;
            }
            if(lt==rt) {
                answer++;
                break;
            }
            if(people[lt]+people[rt]&gt;limit) {
                answer++;
                rt--;   
            }else if (people[lt]+people[rt]&lt;=limit) {
                answer++;
                lt++;
                rt--;
            }
  
        }
        
        
        
        return answer;

    }
    

}</textarea><div class="CodeMirror cm-s-tomorrow-night-bright CodeMirror-wrap CodeMirror-focused" translate="no"><div style="overflow: hidden; position: relative; width: 3px; height: 0px; top: 176.734px; left: 135.078px;"><textarea autocorrect="off" autocapitalize="off" spellcheck="false" tabindex="0" style="position: absolute; bottom: -1em; padding: 0px; width: 1000px; height: 1em; min-height: 1em; outline: none;"></textarea></div><div class="CodeMirror-vscrollbar" tabindex="-1" cm-not-content="true" style="bottom: 0px; display: block;"><div style="min-width: 1px; height: 817px;"></div></div><div class="CodeMirror-hscrollbar" tabindex="-1" cm-not-content="true"><div style="height: 100%; min-height: 1px; width: 0px;"></div></div><div class="CodeMirror-scrollbar-filler" cm-not-content="true"></div><div class="CodeMirror-gutter-filler" cm-not-content="true"></div><div class="CodeMirror-scroll" tabindex="-1"><div class="CodeMirror-sizer" style="margin-left: 48px; margin-bottom: -8px; border-right-width: 42px; min-height: 792px; padding-right: 8px; padding-bottom: 0px;"><div style="position: relative; top: 0px;"><div class="CodeMirror-lines" role="presentation"><div role="presentation" style="position: relative; outline: none;"><div class="CodeMirror-measure"></div><div class="CodeMirror-measure"></div><div style="position: relative; z-index: 1;"></div><div class="CodeMirror-cursors" style="visibility: hidden;"><div class="CodeMirror-cursor" style="left: 87.0781px; top: 156.734px; height: 22.3906px;">&nbsp;</div></div><div class="CodeMirror-code" role="presentation" style=""><div style="position: relative;" class=""><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">1</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"><span class="cm-keyword">import</span> <span class="cm-variable">java</span>.<span class="cm-variable">util</span>.<span class="cm-variable">Arrays</span>;</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">2</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"><span class="cm-keyword">class</span> <span class="cm-def">Solution</span> {</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">3</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp;<span class="cm-keyword">public</span> <span class="cm-type">int</span> <span class="cm-variable">solution</span>(<span class="cm-type">int</span>[] <span class="cm-variable">people</span>, <span class="cm-type">int</span> <span class="cm-variable">limit</span>) {</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">4</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp;<span class="cm-type">int</span> <span class="cm-variable">answer</span> <span class="cm-operator">=</span> <span class="cm-number">0</span>;</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">5</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp;<span class="cm-variable">Arrays</span>.<span class="cm-variable">sort</span>(<span class="cm-variable">people</span>);</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">6</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp;<span class="cm-type">int</span> <span class="cm-variable">lt</span> <span class="cm-operator">=</span> <span class="cm-number">0</span>;</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">7</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp;<span class="cm-type">int</span> <span class="cm-variable">rt</span> <span class="cm-operator">=</span> <span class="cm-variable">people</span>.<span class="cm-variable">length</span><span class="cm-operator">-</span><span class="cm-number">1</span>;</span></pre></div><div style="position: relative;" class="CodeMirror-activeline"><div class="CodeMirror-activeline-background CodeMirror-linebackground"></div><div class="CodeMirror-gutter-background CodeMirror-activeline-gutter" style="left: -48px; width: 48px;"></div><div class="CodeMirror-gutter-wrapper CodeMirror-activeline-gutter" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">8</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp;</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">9</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp;<span class="cm-keyword">while</span>(<span class="cm-atom">true</span>) {</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">10</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="cm-keyword">if</span>(<span class="cm-variable">lt</span><span class="cm-operator">&gt;</span><span class="cm-variable">rt</span>) {</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">11</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="cm-keyword">break</span>;</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">12</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  }</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">13</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="cm-keyword">if</span>(<span class="cm-variable">lt</span><span class="cm-operator">==</span><span class="cm-variable">rt</span>) {</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">14</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="cm-variable">answer</span><span class="cm-operator">++</span>;</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">15</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="cm-keyword">break</span>;</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">16</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  }</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">17</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="cm-keyword">if</span>(<span class="cm-variable">people</span>[<span class="cm-variable">lt</span>]<span class="cm-operator">+</span><span class="cm-variable">people</span>[<span class="cm-variable">rt</span>]<span class="cm-operator">&gt;</span><span class="cm-variable">limit</span>) {</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">18</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="cm-variable">answer</span><span class="cm-operator">++</span>;</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">19</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="cm-variable">rt</span><span class="cm-operator">--</span>; &nbsp; </span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">20</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  }<span class="cm-keyword">else</span> <span class="cm-keyword">if</span> (<span class="cm-variable">people</span>[<span class="cm-variable">lt</span>]<span class="cm-operator">+</span><span class="cm-variable">people</span>[<span class="cm-variable">rt</span>]<span class="cm-operator">&lt;=</span><span class="cm-variable">limit</span>) {</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">21</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="cm-variable">answer</span><span class="cm-operator">++</span>;</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">22</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="cm-variable">lt</span><span class="cm-operator">++</span>;</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">23</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="cm-variable">rt</span><span class="cm-operator">--</span>;</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">24</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  }</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">25</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp;</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">26</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp;  }</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">27</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp;</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">28</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp;</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">29</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp;</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">30</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp; &nbsp; &nbsp;<span class="cm-keyword">return</span> <span class="cm-variable">answer</span>;</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">31</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"><span cm-text="">​</span></span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">32</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp;  }</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">33</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"> &nbsp; &nbsp;</span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">34</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;"><span cm-text="">​</span></span></pre></div><div style="position: relative;"><div class="CodeMirror-gutter-wrapper" aria-hidden="true" style="left: -48px;"><div class="CodeMirror-linenumber CodeMirror-gutter-elt" style="left: 0px; width: 21px;">35</div></div><pre class=" CodeMirror-line " role="presentation"><span role="presentation" style="padding-right: 0.1px;">}</span></pre></div></div></div></div></div></div><div style="position: absolute; height: 42px; width: 1px; border-bottom: 0px solid transparent; top: 792px;"></div><div class="CodeMirror-gutters" style="height: 834px; left: 0px;"><div class="CodeMirror-gutter CodeMirror-linenumbers" style="width: 48px;"></div></div></div></div>
      </div>
    </div>

    <div class="gutter gutter-vertical" style="height: 14px;"></div><div class="output-section" id="tour6" style="height: calc(40% - 7px);">
      <div class="tab-header">
        <div id="output-title" class="output-title" data-toggle="tab">
          <span class="connection-status connected" data-container="body" data-toggle="popover" data-placement="top" title="" data-html="true" data-content="
                  &lt;h6&gt;네트워크가 불안정하여 서버와의 연결이 끊어졌습니다.
                  페이지 새로고침을 하거나 네트워크가 안정적이 되면 자동으로 재 연결됩니다.&lt;/h6&gt;
                  &lt;h6 style=&#39;margin-top: 4px;&#39;&gt;네트워크가 정상임에도 계속해서 연결이 끊어진 상태가 지속된다면 네트워크 방화벽 문제일 수 있습니다.
                  모바일 테더링 등 다른 네트워크를 통해 테스트에 접속해 보세요.&lt;/h6&gt;" data-original-title="서버와의 연결 끊김">
            <svg class="ic-24"><use xlink:href="/assets/svg-defs-341d4ba94dd8e524df08f8b99cf75ce069f44d8f54369ef0fac3ac290d0a7a0d.svg#ic-power-off"></use></svg>
          </span>

          실행 결과
            <a id="stop-button" class="btn btn-sm btn-danger" href="https://programmers.co.kr/learn/courses/30/lessons/42885#">실행 중지</a>
          <span id="output-spinner" class="spinner hidden">
              <span class="bounce1"></span>
              <span class="bounce2"></span>
              <span class="bounce3"></span>
            </span>
        </div>
      </div>
      <div class="console tab-content">
        <div id="output" class="console-output tab-pane fade in active show">
          실행 결과가 여기에 표시됩니다.
          <pre class="console-content"><div></div></pre>
        </div>
      </div>
    </div>
  </div>
</div>

<div class="button-section">
  <div class="testcase-button">
    <a id="btn-show-question" class="btn btn-dark" href="https://programmers.co.kr/learn/courses/30/lessons/42885/questions">질문하기 (62)</a>
      <a class="btn btn-dark btn-block" data-remote="true" href="https://programmers.co.kr/challenge_algorithms/2540/custom_testcases?lesson_id=42885">
        테스트 케이스 추가하기
</a>  </div>

  <div class="func-buttons">
      <a id="view-solution-group" class="btn btn-dark btn-svg" href="https://programmers.co.kr/learn/courses/30/lessons/42885/solution_groups?language=java">
         <span>다른 사람의 풀이</span>
</a>
      <a id="reset-code" class="btn btn-dark" data-trigger="hover" data-toggle="popover" data-placement="top" data-content="에디터의 코드가 초기화됩니다. 초기화 버튼을 누르기 이전 코드 복원하려면 코드 에디터에 커서를 두고 Ctrl-Z를 눌러 보세요." href="https://programmers.co.kr/learn/courses/30/lessons/42885#" data-original-title="" title="">초기화</a>
      <div id="tour4">
        <button name="button" type="submit" id="run-code" class="btn btn-dark" data-trigger="hover" data-toggle="popover" data-placement="top" data-content="작성한 코드를 제출하기 전에 먼저 실행해볼 수 있습니다. 예시 테스트 케이스를 사용하며, [테스트 케이스 추가하기]를 눌러 원하는 테스트 케이스를 추가할 수 있습니다." data-original-title="" title="">코드 실행</button>
      </div>

      <div id="tour5">
        <button name="button" type="submit" id="submit-code" class="btn btn-primary" data-trigger="hover" data-toggle="popover" data-placement="top" data-content="테스트 종료 전까지 언제든 다시 제출할 수 있으며, 제출한 코드 중 가장 높은 점수를 낸 코드가 최종 답안이 됩니다." data-original-title="" title="">제출 후 채점하기</button>
      </div>
  </div>
</div>
</div>
  </div>

</div>



<div class="modal fade" id="modal-dialog" tabindex="-1" role="dialog" aria-hidden="true"></div>

  <script src="./PS_구명보트_정승우_files/library-43a2b911bfee183e36e5225d1081fa1e0a539b15958d5f42c7d649e320f01ba1.js.다운로드" debug="false"></script><div class="tui-tooltip" style="display: none;"><div class="arrow"></div><span class="text"></span></div><div class="tui-tooltip" style="display: none;"><div class="arrow"></div><span class="text"></span></div>
  <script>
//<![CDATA[
    I18n.defaultLocale = "ko";
    I18n.locale = "ko";
    I18n.fallbacks = true;

//]]>
</script>  <script src="./PS_구명보트_정승우_files/application-25cc7824ceef4a1d7b5cdf8f93abb5fed871219db93d33548cca4cc28eeff96a.js.다운로드"></script>


<script>
//<![CDATA[
window.addEventListener('load', function() {});
//]]>
</script>
  <script src="./PS_구명보트_정승우_files/all.js.다운로드" type="text/javascript">
    cloudinary.setCloudName('eightcruz');
  </script>

  <script src="./PS_구명보트_정승우_files/loader.js.다운로드" type="text/javascript"></script>

  <script type="text/javascript">
    "production" !== "local" && Sentry.init({
      environment: "production",
      dsn: "https://96f9fc1ff3f44acbb98a9c156338d14b@o1070092.ingest.sentry.io/6136918",
      integrations: [new Sentry.Integrations.BrowserTracing()],
      initialScope: {
        code_version: "60cf7936ba2fd4def598a4009133cd246f8727a5",
        user: {
          id: 144090,
          username: "정*우",
          email: "tm*******@naver.com"
        },
      },
      // Set tracesSampleRate to 1.0 to capture 100%
      // of transactions for performance monitoring.
      // We recommend adjusting this value in production
      tracesSampleRate: 0.01,
    });
  </script>

<!-- Google Tag Manager (noscript) -->
<noscript>
  <iframe src="https://www.googletagmanager.com/ns.html?id=GTM-NT8HLJD"
          height="0" width="0" style="display:none;visibility:hidden"></iframe>
</noscript>
<!-- End Google Tag Manager (noscript) -->

<script type="text/javascript" charset="utf-8">
  window.addEventListener('afterprint', function() {
      $.ajax({
          type: 'POST',
          url: '/api/action_trackings/print_screen',
          data: {
              current_path: window.location.href
          }
      })
  })
</script>




<noscript>
  이 사이트의 기능을 모두 활용하기 위해서는 자바스크립트를 활성화할 필요가 있습니다.
  <a href="http://www.enable-javascript.com/ko/" target="_blank">
    브라우저에서 자바스크립트를 활성화하는 방법</a>을 참고하세요.
</noscript>




<div id="snackbar-container"></div>
<script type="text/javascript" id="">!function(b,e,f,g,a,c,d){b.fbq||(a=b.fbq=function(){a.callMethod?a.callMethod.apply(a,arguments):a.queue.push(arguments)},b._fbq||(b._fbq=a),a.push=a,a.loaded=!0,a.version="2.0",a.queue=[],c=e.createElement(f),c.async=!0,c.src=g,d=e.getElementsByTagName(f)[0],d.parentNode.insertBefore(c,d))}(window,document,"script","https://connect.facebook.net/en_US/fbevents.js");fbq("init","2050250308523590");fbq("track","PageView");</script>
<noscript>
  <img height="1" width="1" style="display:none" src="https://www.facebook.com/tr?id=2050250308523590&amp;ev=PageView&amp;noscript=1">
</noscript>
</body></html>