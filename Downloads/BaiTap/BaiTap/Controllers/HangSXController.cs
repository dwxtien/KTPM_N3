using BaiTap.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace BaiTap.Controllers
{
    public class HangSXController : Controller
    {
        private Model1 db = new Model1();
        // GET: HangSX
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult DSHangsx()
        {
            List<Hang> ds = db.Hangs.ToList();
            return View(ds);
        }
    }
}