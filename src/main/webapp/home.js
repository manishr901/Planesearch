/*
 * $(document).ready(function() {
 * 
 * $('#go').on('click', function() {
 * 
 * $.ajax({ url : 'flight', data : { from : $('#from').val(), to :
 * $('#to').val() } }); }); });
 */
$(document).ready(
		function() {
			$('#go').on(
					'click',
					function() {

						$.getJSON('flight', {
							from : $('#from').val(),
							to : $('#to').val()
						}, function(data) {

							var from = data.from;

							var to = data.to;

							var plane = data.plane;

							var trHTML = '';

							$.each(data.plane, function(i, item) {
								trHTML += '<tr><td><a href="#download"/>'
										+ data.plane[i] + '</a></td><td>'
										+ data.from[i] + '</td><td>'
										+ data.to[i] + '</td></tr>';
							});

							$('#details').find('tr').eq(1).remove();
							$('#details').append(trHTML);
							$('#plane_search').val(data.plane);
						});

					});
		});
$(document)
		.ready(
				function() {
					$('#plane_search_button')
							.on(
									'click',
									function() {

										$
												.getJSON(
														'schedule',
														{
															plane : $(
																	'#plane_search')
																	.val()

														},
														function(data) {

															var trHTML = '';
															$
																	.each(
																			data.city,
																			function(
																					i,
																					item) {
																				trHTML += '<tr><td><font color=\"black\">'
																						+ data.city[i]
																						+ '</font></td><td><font color=\"black\">'
																						+ data.time[i]
																						+ '</font></td></tr>';
																			});

															$('#schedule')
																	.find('tr')
																	.eq(1)
																	.remove();
															$('#schedule')
																	.append(
																			trHTML);
														});

									});
				});
/*$(document).ready(function() {
$()
})*/
