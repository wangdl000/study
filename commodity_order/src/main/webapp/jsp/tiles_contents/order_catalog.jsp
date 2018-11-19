<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
				<div id="pageTitle">
					<img id="imgTitle" src="images/titles/title_b-001.png" alt="商品のお申し込み" width="748px" height="34px" />
				</div>
				<div id="genre">
					<ul>
						<li class="genreActive">おすすめ商品</li>
						<li><a href="A-001.html">商品ジャンル</a></li>
						<li><a href="A-002.html">一点チョイス</a></li>
						<li><a href="A-002.html">三点チョイス</a></li>
					</ul>
				</div>
				<div id="mainArea" class="mainArea">
					<div class="main">
						<div class="title">
							<strong>[ ご希望商品 ]</strong>
						</div>
						<div class="advice">
							<p>※ 一点チョイスコースの商品は一点のみ、三点チョイスコースの商品は必ず三点お申し込み下さい。
							<br />　　また、三点チョイスと一点チョイスの商品は同時にお申し込みできません。</p>
						</div>
						<div class="left">
							<table class="orderListTable noBorder" width="640px">
								<colgroup width="10%"></colgroup>
								<colgroup width="90%"></colgroup>
								<tr>
									<td class="noBorder">&nbsp;</td>
									<td class="noBorder">（例：12345-6）</td>
								</tr>
								<tr>
									<th class="center" rowspan="3">1</th>
									<td>
										<table class="orderListTableNoBorder" width="600px" cellspacing="6">
											<colgroup width="45%"></colgroup>
											<colgroup width="40%"></colgroup>
											<colgroup width="15%"></colgroup>
											<tr>
												<td class="left" rowspan="3"><input type="text" name="order1-1" size="5" maxlength="5" value="" />-<input type="text" name="order1-2" size="1" maxlength="1" value="" /></td>
												<td class="left"><input type="radio" name="sendTp1" value="1" />最短日にお届け</td>
												<td class="right" rowspan="3"><a href=""><img src="images/common/btn_1-06.png" alt="削除"/></a></td>
											</tr>
											<tr>
												<td class="left"><input type="radio" name="sendTp1" value="2" />ご指定日にお届け</td>
											</tr>
											<tr>
												<td class="sendDate">
<input type="text" name="sendYear1" size="4" maxlength="4" value="" />年
<input type="text" name="sendMonth1" size="2" maxlength="2" value="" />月
<input type="text" name="sendDay1" size="2" maxlength="2" value="" />日
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<table class="orderListTable noBorder" width="640px">
								<colgroup width="10%"></colgroup>
								<colgroup width="90%"></colgroup>
								<tr>
									<th class="center" rowspan="3">2</th>
									<td>
										<table class="orderListTableNoBorder" width="600px" cellspacing="6">
											<colgroup width="45%"></colgroup>
											<colgroup width="40%"></colgroup>
											<colgroup width="15%"></colgroup>
											<tr>
												<td class="left" rowspan="3"><input type="text" name="order1-1" size="5" maxlength="5" value="" />-<input type="text" name="order1-2" size="1" maxlength="1" value="" /></td>
												<td class="left"><input type="radio" name="sendTp1" value="1" />最短日にお届け</td>
												<td class="right" rowspan="3"><a href=""><img src="images/common/btn_1-06.png" alt="削除"/></a></td>
											</tr>
											<tr>
												<td class="left"><input type="radio" name="sendTp1" value="2" />ご指定日にお届け</td>
											</tr>
											<tr>
												<td class="sendDate">
<input type="text" name="sendYear1" size="4" maxlength="4" value="" />年
<input type="text" name="sendMonth1" size="2" maxlength="2" value="" />月
<input type="text" name="sendDay1" size="2" maxlength="2" value="" />日
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<table class="orderListTable noBorder" width="640px">
								<colgroup width="10%"></colgroup>
								<colgroup width="90%"></colgroup>
								<tr>
									<th class="center" rowspan="3">3</th>
									<td>
										<table class="orderListTableNoBorder" width="600px" cellspacing="6">
											<colgroup width="45%"></colgroup>
											<colgroup width="40%"></colgroup>
											<colgroup width="15%"></colgroup>
											<tr>
												<td class="left" rowspan="3"><input type="text" name="order1-1" size="5" maxlength="5" value="" />-<input type="text" name="order1-2" size="1" maxlength="1" value="" /></td>
												<td class="left"><input type="radio" name="sendTp1" value="1" />最短日にお届け</td>
												<td class="right" rowspan="3"><a href=""><img src="images/common/btn_1-06.png" alt="削除"/></a></td>
											</tr>
											<tr>
												<td class="left"><input type="radio" name="sendTp1" value="2" />ご指定日にお届け</td>
											</tr>
											<tr>
												<td class="sendDate">
<input type="text" name="sendYear1" size="4" maxlength="4" value="" />年
<input type="text" name="sendMonth1" size="2" maxlength="2" value="" />月
<input type="text" name="sendDay1" size="2" maxlength="2" value="" />日
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<table class="orderListTableNoBorder" width="640px">
								<colgroup width="10%"></colgroup>
								<colgroup width="90%"></colgroup>
								<tr>
									<td class="center">&nbsp;</td>
									<td>
										<table class="orderListTableNoBorder" width="600px" cellspacing="6">
											<tr>
												<td class="right" rowspan="3"><a href=""><img src="images/common/btn_1-07.png" alt="全て削除"/></a></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</div>
						<div class="advice">
							<p>ご希望の商品のお届け希望日をご入力ください。</p>
							<p>※ 現在表示されている日程より前は選択できません。</p>
							<p>※ 配送状況によってお届け日のご希望には添えない場合がございます。<br />　　配送時間はご指定になれません。</p>
						</div>
					</div>
					<div class="linkBtn">
						<table border="0" width="100%">
							<tr>
								<td class="right"><a href="A-005.html" ><img src="images/order/btn_2-09.png" alt="商品の確認へ"/></a></td>
							</tr>
						</table>
					</div>
				</div><!-- mainArea -->