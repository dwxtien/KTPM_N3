using BaiTap.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace BaiTap.Controllers
{
    public class DanhMucController : Controller
    {
        // GET: DanhMuc
        private Model1 db = new Model1();
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult DsDanhMuc()
        {
            List<DanhMuc> ds = db.DanhMucs.ToList();
            return View(ds);
        }
    }
}