<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Salary Config</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
	 <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="../../../code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Tempusdominus Bootstrap 4 -->
  <link rel="stylesheet" href="plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- JQVMap -->
  <link rel="stylesheet" href="plugins/jqvmap/jqvmap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min2167.css?v=3.2.0">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="plugins/daterangepicker/daterangepicker.css">
  <!-- summernote -->
  <link rel="stylesheet" href="plugins/summernote/summernote-bs4.min.css">
<script data-cfasync="false" nonce="06cb1374-3a81-4a88-aebe-16de25f6e552">try{(function(w,d){!function(j,k,l,m){if(j.zaraz)console.error("zaraz is loaded twice");else{j[l]=j[l]||{};j[l].executed=[];j.zaraz={deferred:[],listeners:[]};j.zaraz._v="5870";j.zaraz._n="06cb1374-3a81-4a88-aebe-16de25f6e552";j.zaraz.q=[];j.zaraz._f=function(n){return async function(){var o=Array.prototype.slice.call(arguments);j.zaraz.q.push({m:n,a:o})}};for(const p of["track","set","debug"])j.zaraz[p]=j.zaraz._f(p);j.zaraz.init=()=>{var q=k.getElementsByTagName(m)[0],r=k.createElement(m),s=k.getElementsByTagName("title")[0];s&&(j[l].t=k.getElementsByTagName("title")[0].text);j[l].x=Math.random();j[l].w=j.screen.width;j[l].h=j.screen.height;j[l].j=j.innerHeight;j[l].e=j.innerWidth;j[l].l=j.location.href;j[l].r=k.referrer;j[l].k=j.screen.colorDepth;j[l].n=k.characterSet;j[l].o=(new Date).getTimezoneOffset();if(j.dataLayer)for(const t of Object.entries(Object.entries(dataLayer).reduce((u,v)=>({...u[1],...v[1]}),{})))zaraz.set(t[0],t[1],{scope:"page"});j[l].q=[];for(;j.zaraz.q.length;){const w=j.zaraz.q.shift();j[l].q.push(w)}r.defer=!0;for(const x of[localStorage,sessionStorage])Object.keys(x||{}).filter(z=>z.startsWith("_zaraz_")).forEach(y=>{try{j[l]["z_"+y.slice(7)]=JSON.parse(x.getItem(y))}catch{j[l]["z_"+y.slice(7)]=x.getItem(y)}});r.referrerPolicy="origin";r.src="../../cdn-cgi/zaraz/sd0d9.js?z="+btoa(encodeURIComponent(JSON.stringify(j[l])));q.parentNode.insertBefore(r,q)};["complete","interactive"].includes(k.readyState)?zaraz.init():j.addEventListener("DOMContentLoaded",zaraz.init)}}(w,d,"zarazData","script");window.zaraz._p=async bs=>new Promise(bt=>{if(bs){bs.e&&bs.e.forEach(bu=>{try{const bv=d.querySelector("script[nonce]"),bw=bv?.nonce||bv?.getAttribute("nonce"),bx=d.createElement("script");bw&&(bx.nonce=bw);bx.innerHTML=bu;bx.onload=()=>{d.head.removeChild(bx)};d.head.appendChild(bx)}catch(by){console.error(`Error executing script: ${bu}\n`,by)}});Promise.allSettled((bs.f||[]).map(bz=>fetch(bz[0],bz[1])))}bt()});zaraz._p({"e":["(function(w,d){})(window,document)"]});})(window,document)}catch(e){throw fetch("/cdn-cgi/zaraz/t"),e;};</script>

	
<style>
body {
	background: #f8f9fa;
}

.config-container {
	margin: 30px;
	padding: 20px;
	background: #fff;
	border-radius: 12px;
	box-shadow: 0 3px 8px rgba(0, 0, 0, 0.1);
}

.btn-add {
	background: #ff6f00;
	color: white;
	font-weight: bold;
}

.btn-add:hover {
	background: #e65c00;
}

.d-none {
	display: none !important;
}

/* Modal overlay */
.modal-overlay {
	display: none;
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
	background: rgba(0, 0, 0, 0.5);
	backdrop-filter: blur(5px);
	z-index: 1000;
	display: flex;
	align-items: center;
	justify-content: center;
}

.modal-box {
	background: white;
	padding: 20px;
	border-radius: 12px;
	width: 420px;
	box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
}

.modal-header {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.close-btn {
	border: none;
	background: transparent;
	font-size: 20px;
	cursor: pointer;
}
</style>
</head>
<body class="hold-transition sidebar-mini layout-fixed">

<jsp:include page="../../../navbar.jsp"></jsp:include>

<jsp:include page="../../../sidebar.jsp"></jsp:include>



<div class="wrapper">
	<div class="content-wrapper">
		<div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">Dashboard</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Dashboard v1</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
		<section class="content">

	<div class="config-container">
		<div class="d-flex justify-content-between mb-3">
			<div>
				<!-- Two dropdowns -->
				<select id="earningSelect" class="form-select d-inline w-auto me-2">
					<option value="" disabled selected hidden>Choose</option>
					<option value="earning">Earning</option>
					<option value="earningType">Earning Type</option>
				</select> <select id="deductionSelect" class="form-select d-inline w-auto">
					<option value="" disabled selected hidden>Choose</option>
					<option value="deduction">Deduction</option>
					<option value="deductionType">Deduction Type</option>
				</select>
			</div>

			<button id="addBtn" class="btn btn-add">Add Earning</button>
		</div>

		<!-- Table -->
		<div id="tableContainer">
			<table class="table table-bordered text-center align-middle">
				<thead class="table-light">
					<tr id="tableHeader"></tr>
				</thead>
				<tbody id="tableBody">
					<!-- Earnings -->
					<c:forEach var="earning" items="${earnings}">
						<tr class="earning-row">
							<td>${earning.earningId}</td>
							<td>${earning.earningTypeName}</td>
							<td>${earning.earningPercentage}</td>
							<td>${earning.departmentName}</td>
							<td>${earning.designationName}</td>
							<td>
								<!-- Edit button: data attributes used to populate modal -->
								<button type="button"
									class="btn btn-sm btn-outline-primary editBtn"
									data-type="earning" data-id="${earning.earningId}"
									data-percentage="${earning.earningPercentage}"
									data-department="${earning.departmentId}"
									data-designation="${earning.designationId}"
									data-earningtypeid="${earning.earningTypeId}">✏</button> <!-- Delete uses a small form POST to servlet -->
								<form method="post" action="salaryConfig"
									style="display: inline"
									onsubmit="return confirm('Delete this earning?');">
									<input type="hidden" name="action" value="deleteEarning" /> <input
										type="hidden" name="id" value="${earning.earningId}" />
									<button type="submit" class="btn btn-sm btn-outline-danger">🗑</button>
								</form>
							</td>
						</tr>
					</c:forEach>

					<!-- Earning Types -->
					<c:forEach var="etype" items="${earningTypes}">
						<tr class="earningType-row d-none">
							<td>${etype.earningTypeId}</td>
							<td>${etype.earningTypeName}</td>
							<td>
								<button type="button"
									class="btn btn-sm btn-outline-primary editBtn"
									data-type="earningType" data-id="${etype.earningTypeId}"
									data-name="${etype.earningTypeName}">✏</button>

								<form method="post" action="salaryConfig"
									style="display: inline"
									onsubmit="return confirm('Delete this earning type?');">
									<input type="hidden" name="action" value="deleteEarningType" />
									<input type="hidden" name="earningId"
										value="${etype.earningTypeId}" />
									<button type="submit" class="btn btn-sm btn-outline-danger">🗑</button>
								</form>
							</td>
						</tr>
					</c:forEach>

					<!-- Deductions -->
					<c:forEach var="deduction" items="${deductions}">
						<tr class="deduction-row d-none">
							<td>${deduction.deductionId}</td>
							<td>
								<!-- show deductionTypeId since model doesn't have a name field -->
								${deduction.deductionTypeName}
							</td>
							<td>${deduction.deductionPercentage}</td>
							<td>${deduction.departmentName}</td>
							<td>${deduction.designationName}</td>
							<td>
								<button type="button"
									class="btn btn-sm btn-outline-primary editBtn"
									data-type="deduction" data-id="${deduction.deductionId}"
									data-percentage="${deduction.deductionPercentage}"
									data-department="${deduction.departmentId}"
									data-designation="${deduction.designationId}"
									data-deductiontypeid="${deduction.deductionTypeId}">✏</button>

								<form method="post" action="salaryConfig"
									style="display: inline"
									onsubmit="return confirm('Delete this deduction?');">
									<input type="hidden" name="action" value="deleteDeduction" />
									<input type="hidden" name="id" value="${deduction.deductionId}" />
									<button type="submit" class="btn btn-sm btn-outline-danger">🗑</button>
								</form>
							</td>
						</tr>
					</c:forEach>

					<!-- Deduction Types -->
					<c:forEach var="dtype" items="${deductionTypes}">
						<tr class="deductionType-row d-none">
							<td>${dtype.deductionTypeId}</td>
							<td>${dtype.deductionTypeName}</td>
							<td>
								<button type="button"
									class="btn btn-sm btn-outline-primary editBtn"
									data-type="deductionType" data-id="${dtype.deductionTypeId}"
									data-name="${dtype.deductionTypeName}">✏</button>

								<form method="post" action="salaryConfig"
									style="display: inline"
									onsubmit="return confirm('Delete this deduction type?');">
									<input type="hidden" name="action" value="deleteDeductionType" />
									<input type="hidden" name="deductionId"
										value="${dtype.deductionTypeId}" />
									<button type="submit" class="btn btn-sm btn-outline-danger">🗑</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>

	<!-- Modal -->
	<div id="modalOverlay" class="modal-overlay" style="display: none">
		<div class="modal-box">
			<div class="modal-header">
				<h5 id="formTitle">Add</h5>
				<button class="close-btn" onclick="closeModal()">×</button>
			</div>
			<!-- Form wired to servlet -->
			<form id="dynamicForm" method="post" action="salaryConfig">
				<input type="hidden" name="action" id="formAction">
				<div id="formFields"></div>
			</form>
		</div>
	</div>
	
	
	</section>
	</div>
</div>

<jsp:include page="../../../footer.jsp"></jsp:include>


<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<script src="plugins/jqvmap/jquery.vmap.min.js"></script>
<script src="plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
<!-- jQuery Knob Chart -->
<script src="plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="plugins/moment/moment.min.js"></script>
<script src="plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte2167.js?v=3.2.0"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="dist/js/pages/dashboard.js"></script>
<script defer src="https://static.cloudflareinsights.com/beacon.min.js/vcd15cbe7772f49c399c6a5babf22c1241717689176015" integrity="sha512-ZpsOmlRQV6y907TI0dKBHq9Md29nnaEIPlkf84rnaERnq6zvWvPUqr2ft8M1aS28oN72PdrCzSjY4U6VaAw1EQ==" data-cf-beacon='{"rayId":"97edd8cbed143e57","version":"2025.8.0","serverTiming":{"name":{"cfExtPri":true,"cfEdge":true,"cfOrigin":true,"cfL4":true,"cfSpeedBrain":true,"cfCacheStatus":true}},"token":"2437d112162f4ec4b63c3ca0eb38fb20","b":1}' crossorigin="anonymous"></script>
	

	<script>
    const earningSelect = document.getElementById("earningSelect");
    const deductionSelect = document.getElementById("deductionSelect");
    const addBtn = document.getElementById("addBtn");
    const modalOverlay = document.getElementById("modalOverlay");
    const formTitle = document.getElementById("formTitle");
    const formFields = document.getElementById("formFields");
    const tableHeader = document.getElementById("tableHeader");

    let currentType = "earning"; // default active type

    function updateUI(type) {
        currentType = type; 
        let btnText = "Add ";
        let tableCols = "";

        // Hide all rows
        document.querySelectorAll(".earning-row").forEach(r => r.classList.add("d-none"));
        document.querySelectorAll(".earningType-row").forEach(r => r.classList.add("d-none"));
        document.querySelectorAll(".deduction-row").forEach(r => r.classList.add("d-none"));
        document.querySelectorAll(".deductionType-row").forEach(r => r.classList.add("d-none"));

        if (type === "earning") {
            btnText += "Earning";
            tableCols = `<th>Id</th><th>Earning Type Id</th><th>Earning %</th><th>Department</th><th>Designation</th><th>Action</th>`;
            document.querySelectorAll(".earning-row").forEach(r => r.classList.remove("d-none"));
        } else if (type === "earningType") {
            btnText += "Earning Type";
            tableCols = `<th>Id</th><th>Earning Type</th><th>Action</th>`;
            document.querySelectorAll(".earningType-row").forEach(r => r.classList.remove("d-none"));
        } else if (type === "deduction") {
            btnText += "Deduction";
            tableCols = `<th>Id</th><th>Deduction Type Id</th><th>Deduction %</th><th>Department</th><th>Designation</th><th>Action</th>`;
            document.querySelectorAll(".deduction-row").forEach(r => r.classList.remove("d-none"));
        } else if (type === "deductionType") {
            btnText += "Deduction Type";
            tableCols = `<th>Id</th><th>Deduction Type</th><th>Action</th>`;
            document.querySelectorAll(".deductionType-row").forEach(r => r.classList.remove("d-none"));
        }

        addBtn.innerText = btnText;
        tableHeader.innerHTML = tableCols;
    }

    // Build modal form HTML (server-side loops produce options)
    function buildForm(type) {
        // clear any previous content
        formFields.innerHTML = "";
        // remove any hidden id inputs (if present)
        const existingHidden = dynamicForm.querySelector("input[name='id']");
        if (existingHidden) existingHidden.remove();

        formTitle.innerText = addBtn.innerText;

        if (type === "earningType") {
            document.getElementById("formAction").value = "addEarningType";
            formFields.innerHTML = `
                <input type="text" class="form-control mb-2" name="earningTypeName" placeholder="Earning Type" required>
                <button type="submit" class="btn btn-success mt-2">Save</button>
            `;
        } else if (type === "deductionType") {
            document.getElementById("formAction").value = "addDeductionType";
            formFields.innerHTML = `
                <input type="text" class="form-control mb-2" name="deductionTypeName" placeholder="Deduction Type" required>
                <button type="submit" class="btn btn-success mt-2">Save</button>
            `;
        } else if (type === "earning") {
            document.getElementById("formAction").value = "addEarning";
            formFields.innerHTML = `
                <label class="form-label">Earning Type</label>
                <select name="earningTypeId" class="form-select mb-2" required>
                    <option value="">-- Select Earning Type --</option>
                    <c:forEach var="etype" items="${earningTypes}">
                        <option value="${etype.earningTypeId}">${etype.earningTypeName}</option>
                    </c:forEach>
                </select>
                <input type="number" step="0.01" class="form-control mb-2" name="earningPercentage" placeholder="Percentage" required>
                
                <select id="departmentDropdown" name="departmentId" class="form-select mb-2" 
                    onchange="fetchDesignations(this.value)" required>
                <option value="">-- Select Department --</option>
                <c:forEach var="d" items="${departments}">
                    <option value="${d.departmentId}">${d.departmentName}</option>
                </c:forEach>
            </select>

            <select id="designationDropdown" name="designationId" class="form-select mb-2" required>
                <option value="">-- Select Designation --</option>
                <!-- Will be filled dynamically -->
            </select>

            
                <button type="submit" class="btn btn-success mt-2">Save</button>
            `;
        } else if (type === "deduction") {
            document.getElementById("formAction").value = "addDeduction";
            formFields.innerHTML = `
                <label class="form-label">Deduction Type</label>
                <select name="deductionTypeId" class="form-select mb-2" required>
                    <option value="">-- Select Deduction Type --</option>
                    <c:forEach var="dtype" items="${deductionTypes}">
                        <option value="${dtype.deductionTypeId}">${dtype.deductionTypeName}</option>
                    </c:forEach>
                </select>
                <input type="number" step="0.01" class="form-control mb-2" name="deductionPercentage" placeholder="Percentage" required>
                <select id="departmentDropdown" name="departmentId" class="form-select mb-2" 
                    onchange="fetchDesignations(this.value)" required>
                <option value="">-- Select Department --</option>
                <c:forEach var="d" items="${departments}">
                    <option value="${d.departmentId}">${d.departmentName}</option>
                </c:forEach>
            </select>

            <select id="designationDropdown" name="designationId" class="form-select mb-2" required>
                <option value="">-- Select Designation --</option>
                <!-- Will be filled dynamically -->
            </select>

                <button type="submit" class="btn btn-success mt-2">Save</button>
            `;
        }

        // After building form, attach listeners to the new Save button if needed (form submit will post to servlet)
    }

    // Attach edit handlers (for pre-filling modal)
    function attachEditButtons() {
        document.querySelectorAll(".editBtn").forEach(btn => {
            btn.removeEventListener('click', btn._editHandler); // remove old if any
            const handler = function () {
                const type = this.getAttribute("data-type");
                const id = this.getAttribute("data-id");

                buildForm(type);  // build base form (Add mode)
                formTitle.innerText = "Edit";

                // set update action and prefill fields
                if (type === "earningType") {
                    document.getElementById("formAction").value = "updateEarningType";
                    // set input value after DOM inserted
                    setTimeout(() => {
                        const nameInput = document.querySelector("input[name='earningTypeName']");
                        if (nameInput) nameInput.value = this.getAttribute("data-name");
                        // add hidden id
                        addHiddenId(id);
                    }, 0);
                } else if (type === "deductionType") {
                    document.getElementById("formAction").value = "updateDeductionType";
                    setTimeout(() => {
                        const nameInput = document.querySelector("input[name='deductionTypeName']");
                        if (nameInput) nameInput.value = this.getAttribute("data-name");
                        addHiddenId(id);
                    }, 0);
                } else if (type === "earning") {
                    document.getElementById("formAction").value = "updateEarning";
                    setTimeout(() => {
                        const sel = document.querySelector("select[name='earningTypeId']");
                        if (sel) sel.value = this.getAttribute("data-earningtypeid");

                        const perc = document.querySelector("input[name='earningPercentage']");
                        if (perc) perc.value = this.getAttribute("data-percentage");

                        const sel1 = document.querySelector("select[name='departmentId']");
                        if (sel1) sel1.value = this.getAttribute("data-department");
                        


                        const sel2 = document.querySelector("select[name='designationId']");
                        if (sel2) sel2.value = this.getAttribute("data-designation");

                        addHiddenId(id);
                    }, 0);
                } else if (type === "deduction") {
                    document.getElementById("formAction").value = "updateDeduction";
                    setTimeout(() => {
                        const sel = document.querySelector("select[name='deductionTypeId']");
                        if (sel) sel.value = this.getAttribute("data-deductiontypeid");

                        const perc = document.querySelector("input[name='deductionPercentage']");
                        if (perc) perc.value = this.getAttribute("data-percentage");

                        const sel1 = document.querySelector("select[name='departmentId']");
                        if (sel1) sel1.value = this.getAttribute("data-department");

                        const sel2 = document.querySelector("select[name='designationId']");
                        if (sel2) sel2.value = this.getAttribute("data-designation");

                        addHiddenId(id);
                    }, 0);
                }

                modalOverlay.style.display = "flex";
            };
            btn.addEventListener('click', handler);
            btn._editHandler = handler;
        });
    }

    function addHiddenId(id) {
        // remove existing id if present
        const existing = document.querySelector("input[name='id']");
        if (existing) existing.remove();
        const hf = document.createElement("input");
        hf.type = "hidden";
        hf.name = "id";
        hf.value = id;
        document.getElementById("dynamicForm").appendChild(hf);
    }

    earningSelect.addEventListener("change", (e) => updateUI(e.target.value));
    deductionSelect.addEventListener("change", (e) => updateUI(e.target.value));

    addBtn.addEventListener("click", function () {
        buildForm(currentType);
        // ensure we are in "add" flow (remove any id and set add action)
        if (currentType === "earning") document.getElementById("formAction").value = "addEarning";
        if (currentType === "earningType") document.getElementById("formAction").value = "addEarningType";
        if (currentType === "deduction") document.getElementById("formAction").value = "addDeduction";
        if (currentType === "deductionType") document.getElementById("formAction").value = "addDeductionType";
        const existing = document.querySelector("input[name='id']");
        if (existing) existing.remove();
        modalOverlay.style.display = "flex";
    });

    function closeModal() {
        modalOverlay.style.display = "none";
    }

    // initialize UI & handlers after page load
    document.addEventListener("DOMContentLoaded", function () {
        updateUI("earning");
        attachEditButtons();
    });

    
    function fetchDesignations(deptId) {
    	  fetch('DesignationServlet?action=getByDepartment&deptId=' + deptId)
    	    .then(response => response.json())
    	    .then(data => {
    	      const designationSelect = document.getElementById("designationDropdown");
    	      designationSelect.innerHTML = ""; // Clear old options

    	      data.forEach(des => {
    	        const option = document.createElement("option");
    	        option.value = des.designationId;
    	        option.text = des.designationName;
    	        designationSelect.appendChild(option);
    	      });
    	    })
    	    .catch(error => console.error("Error fetching designations:", error));
    	}
    // re-attach edit buttons if you dynamically change table (not used here, but kept for completeness)
    // e.g., after AJAX replace call you may call attachEditButtons();
</script>

</body>
</html>
